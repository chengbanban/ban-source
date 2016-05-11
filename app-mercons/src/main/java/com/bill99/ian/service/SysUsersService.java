package com.bill99.ian.service;

import java.util.List;
import java.util.Map;

import com.bill99.ian.entity.SysAuthorities;
import com.bill99.ian.entity.SysUsers;
import com.bill99.ian.entity.SysUsersRoles;

public interface SysUsersService {
	
	/**
	 * 用户注册入库
	 * @param user
	 */
	public void save(SysUsers user);
	
	/**
	 * 根据用户名查询对应用户的所有权限
	 * @param username
	 * @return
	 */
	public List<SysAuthorities> findAuthByUserName(String username);
	
	/**
	 * 根据用户名获取用户对象
	 * @param username
	 * @return
	 */
	public SysUsers findUserByAccount(String username);
	
	public void getUserId(Map<String, String> seqMap);
	
	public void registerUser(SysUsers user, SysUsersRoles usersRoles);
}
