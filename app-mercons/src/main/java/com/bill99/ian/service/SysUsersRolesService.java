package com.bill99.ian.service;

import java.util.List;

import com.bill99.ian.entity.SysUsersRoles;

public interface SysUsersRolesService {
	
	List<SysUsersRoles> findByUserId(String userId);

}
