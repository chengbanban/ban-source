package com.bill99.ian.security;

import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class MyLogoutFilter extends LogoutFilter {

	public MyLogoutFilter(String logoutSuccessUrl, LogoutHandler[] handlers) {
		super(logoutSuccessUrl, handlers);
		// TODO Auto-generated constructor stub
		System.out.println("用户注销 自定义 过滤器...");
	}

}
