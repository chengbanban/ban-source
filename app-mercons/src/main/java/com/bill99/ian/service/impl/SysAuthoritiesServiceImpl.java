package com.bill99.ian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.ian.dao.SysAuthoritiesMapper;
import com.bill99.ian.entity.SysAuthorities;
import com.bill99.ian.service.SysAuthoritiesService;

@Service("sysAuthoritiesService")
public class SysAuthoritiesServiceImpl implements SysAuthoritiesService {

	@Autowired
	private SysAuthoritiesMapper authoritiesMapper;
	
	@Override
	public List<SysAuthorities> getAll() {
		return authoritiesMapper.selectAll();
	}

	@Override
	public SysAuthorities findById(String authorityId) {
		return authoritiesMapper.selectByPrimaryKey(authorityId);
	}
}
