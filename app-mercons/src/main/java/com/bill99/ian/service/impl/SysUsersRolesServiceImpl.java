package com.bill99.ian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.ian.dao.SysUsersRolesMapper;
import com.bill99.ian.entity.SysUsersRoles;
import com.bill99.ian.service.SysUsersRolesService;

@Service("sysUsersRolesService")
public class SysUsersRolesServiceImpl implements SysUsersRolesService {

	@Autowired
	private SysUsersRolesMapper sysUsersRolesMapper;
	
	@Override
	public List<SysUsersRoles> findByUserId(String userId) {
		return sysUsersRolesMapper.selectByUserId(userId);
	}

}
