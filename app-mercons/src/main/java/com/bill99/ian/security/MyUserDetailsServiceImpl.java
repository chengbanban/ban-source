package com.bill99.ian.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bill99.ian.entity.SysUsers;
import com.bill99.ian.service.SysAuthoritiesResourcesService;
import com.bill99.ian.service.SysUsersService;

public class MyUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private SysUsersService userService;
	
	@Autowired
	private SysAuthoritiesResourcesService authoritiesResourcesSevice;
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private BCryptPasswordEncoder myPwdEncoder;
	
	/**
	 * 从数据库中读入用户的密码，角色信息，是否锁定，账号是否过期
	 * @param username 
	 * @return
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>(); 
		//取得用户的权限
        auths  = userManager.loadUserAuthoritiesByName(username);
        // 根据用户名取得一个SysUsers对象，以获取该用户的其他信息。
        SysUsers user = userService.findUserByAccount(username);
        System.out.println("登录用户校验(数据库信息), userName:" + user.getUserName()+", userPassWord:"+user.getUserPassword());  
        //myPwdEncoder.matches(rawPassword, encodedPassword)
        return new SysUsers(
        		username,//username
        		user.getUserAccount(),
        		user.getUserPassword(),//password
                1,//enabled
                true,//accountNonExpired
                true,//credentialsNonExpired
                true,//accountNonLocked
                auths);
	}

}
