package com.bill99.ian.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Service;

import com.bill99.ian.entity.SysRolesAuthorities;
import com.bill99.ian.entity.SysUsers;
import com.bill99.ian.entity.SysUsersRoles;
import com.bill99.ian.service.SysUsersRolesService;
import com.bill99.ian.service.SysUsersService;

@Service("userManager")
public class UserManager {

	@Autowired
	private SysUsersService sysUsersService;
	
	@Autowired
	private SysUsersRolesService sysUsersRolesService;
	
	@SuppressWarnings("deprecation")
	public List<GrantedAuthority> loadUserAuthoritiesByName(String username) {
		try {
			List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
			List<String> authList = loadUserAuthorities(username);
			for (String authorityName : authList) {
				 System.out.println(getClass().getName()+authorityName);  
	             GrantedAuthority authority = new GrantedAuthorityImpl(authorityName);  
	             auths.add(authority);
			}
			return auths;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public List<String> loadUserAuthorities(String username){
		try {
			List<String> authNameList = new ArrayList<String>();
			//根据用户名获得user
			SysUsers user = sysUsersService.findUserByAccount(username);
			//根据user获得roles 
			List<SysUsersRoles> userRoles = sysUsersRolesService.findByUserId(user.getUserId());
			for (SysUsersRoles userRole : userRoles) {
				Set<SysRolesAuthorities> roleAuths = userRole.getSysRoles().getSysRolesAuthorities();
				for (SysRolesAuthorities roleAuth : roleAuths) {
					String authName = roleAuth.getSysAuthorities().getAuthorityName();
					authNameList.add(authName);
				}
			}
			return authNameList;
		} catch (RuntimeException re) {
			System.out.println("find by authorities by username failed."  
                    + re.getMessage());  
            throw re;
		}
	}
}
