package com.bill99.ian.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import com.bill99.ian.entity.SysAuthorities;
import com.bill99.ian.entity.SysAuthoritiesResources;
import com.bill99.ian.entity.SysResources;
import com.bill99.ian.service.SysAuthoritiesResourcesService;
import com.bill99.ian.service.SysAuthoritiesService;
import com.bill99.ian.service.SysResourcesService;

/**
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。 
 * 此类在初始化时，应该取到所有资源及其对应角色的定义。
 * @author haipeng.cheng
 *
 */
public class MyInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	private AntPathMatcher urlMatcher = new AntPathMatcher();
	
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	
	@Resource(name="sysAuthoritiesResourcesService")
	private SysAuthoritiesResourcesService sysAuthoritiesResourcesService;
	
	@Autowired
	private SysAuthoritiesService sysAuthoritiesService;
	
	@Resource(name="sysResourcesService")
	private SysResourcesService sysResourcesService;
	
	public MyInvocationSecurityMetadataSource() {
        //loadResourceDefine();
    }
	
	public void loadResourceDefine() {
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        //获取所有的权限列表
        List<SysAuthorities> authoritiesList = sysAuthoritiesService.getAll();
        System.out.println("配置的权限记录总数：" + authoritiesList.size());
        for (SysAuthorities authority : authoritiesList) {
        	String authorityName = authority.getAuthorityName();//权限名称
            Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        	ConfigAttribute ca = new SecurityConfig(authorityName);//ROLE_USER等
        	//获取 权限authorityName下所有的资源名称-URL。
        	List<SysAuthoritiesResources> authResources = sysAuthoritiesResourcesService.findByAuthorityId(authority.getAuthorityId());
        	for (SysAuthoritiesResources authResource : authResources) {
        		SysResources resource = authResource.getSysResources();
        		String url = resource.getResourceString();
        		// 判断资源文件和权限的对应关系，如果已经存在，要进行增加 
			    if (resourceMap.containsKey(url)) {
			    	Collection<ConfigAttribute> value = resourceMap.get(url);
				    value.add(ca);
				    System.out.println("权限资源配置：key=" +url + ", value=" + value);
				    resourceMap.put(url, value);
				    // "log.jsp","role_user,role_admin"
			     } else {
	    		    atts.add(ca);
					System.out.println("权限资源配置：key=" +url + ", value=" + atts);
	    		    resourceMap.put(url, atts);
			     }
        	}
        }
    }
	
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		// object 是一个URL，被用户请求的url。  
        String url = ((FilterInvocation) object).getRequestUrl();  
        int firstQuestionMarkIndex = url.indexOf("?");
        if (firstQuestionMarkIndex != -1) {
            url = url.substring(0, firstQuestionMarkIndex);
        }
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            if (urlMatcher.match(url, resURL)) {
            	Iterator<ConfigAttribute> its = resourceMap.get(resURL).iterator();
            	System.out.println("请求地址:" + url + "对应的访问权限有：");
            	String roles = "";
                while (its.hasNext()) {
                    ConfigAttribute ca = its.next();
                    String needRole = ca.getAttribute();
                    roles = roles + needRole + " ";
                }
                System.out.println(roles);
                return resourceMap.get(resURL);
            }
        }
        return null; 
	}

	@Override
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return true;
	}

	public void setSysAuthoritiesResourcesService(
			SysAuthoritiesResourcesService sysAuthoritiesResourcesService) {
		this.sysAuthoritiesResourcesService = sysAuthoritiesResourcesService;
	}

	public void setSysAuthoritiesService(SysAuthoritiesService sysAuthoritiesService) {
		this.sysAuthoritiesService = sysAuthoritiesService;
	}

	public void setSysResourcesService(SysResourcesService sysResourcesService) {
		this.sysResourcesService = sysResourcesService;
	}

	public SysAuthoritiesResourcesService getSysAuthoritiesResourcesService() {
		return sysAuthoritiesResourcesService;
	}

	public SysAuthoritiesService getSysAuthoritiesService() {
		return sysAuthoritiesService;
	}

	public SysResourcesService getSysResourcesService() {
		return sysResourcesService;
	}

}
