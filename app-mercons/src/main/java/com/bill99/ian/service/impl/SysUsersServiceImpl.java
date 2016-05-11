package com.bill99.ian.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bill99.ian.dao.SysRolesAuthoritiesMapper;
import com.bill99.ian.dao.SysUsersMapper;
import com.bill99.ian.dao.SysUsersRolesMapper;
import com.bill99.ian.entity.SysAuthorities;
import com.bill99.ian.entity.SysUsers;
import com.bill99.ian.entity.SysUsersRoles;
import com.bill99.ian.service.SysUsersService;

@Service("sysUsersService")
public class SysUsersServiceImpl implements SysUsersService {

	@Autowired
	private SysUsersMapper sysUsersMapper;
	
	@Autowired
	private SysUsersRolesMapper sysUsersRolesMapper;
	
	@Autowired
	private SysRolesAuthoritiesMapper sysRolesAuthoritiesMapper;
	
	@Override
	public void save(SysUsers user) {
		sysUsersMapper.insert(user);
	}
	
	@Override
	public List<SysAuthorities> findAuthByUserName(String username) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userName", username);
		return sysUsersMapper.findAuthoritiesByMap(paramMap);
	}

	@Override
	public SysUsers findUserByAccount(String username) {
		return sysUsersMapper.findByUserAccount(username);
	}

	@Override
	public void getUserId(Map<String, String> seqMap) {
		sysUsersMapper.getSeqUserId(seqMap);
	}

	@Override
	public void registerUser(SysUsers user, SysUsersRoles usersRoles) {
		sysUsersMapper.insert(user);
		sysUsersRolesMapper.insert(usersRoles);
	}
}
