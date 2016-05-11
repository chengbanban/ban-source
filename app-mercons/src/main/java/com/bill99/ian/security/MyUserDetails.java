package com.bill99.ian.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface MyUserDetails extends UserDetails {
	//用户id
	public String getUserId();
	//用户账户
	public String getUserAccount();
	//用户名
	public String getUserName();
	//用户密码
	public String getUserPassword();
	//用户描述或简介
	public String getUserDesc();
	//用户是否能用
	public boolean getEnabled();
	//是否超级用户
	public boolean getIssys();
	//所属的单位
	public String getUserDept();
	//用户职位
	public String getUserDuty();
	//用户分管的子系统
	public String getSubSystem();
}
