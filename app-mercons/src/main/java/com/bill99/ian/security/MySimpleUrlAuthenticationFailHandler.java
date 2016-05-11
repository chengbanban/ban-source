package com.bill99.ian.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class MySimpleUrlAuthenticationFailHandler implements
		AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(
			HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse,
			AuthenticationException paramAuthenticationException)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		paramAuthenticationException.printStackTrace();
	}

}
