package com.bill99.ian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.ian.dao.SysAuthoritiesResourcesMapper;
import com.bill99.ian.entity.SysAuthoritiesResources;
import com.bill99.ian.service.SysAuthoritiesResourcesService;

@Service("sysAuthoritiesResourcesService")
public class SysAuthoritiesResourcesServiceImpl implements
		SysAuthoritiesResourcesService {

	@Autowired
	private SysAuthoritiesResourcesMapper authoritiesResourcesMapper;
	
	@Override
	public List<SysAuthoritiesResources> getAll() {
		return authoritiesResourcesMapper.selectAll();
	}

	@Override
	public List<SysAuthoritiesResources> findByAuthorityId(String authorityId) {
		return authoritiesResourcesMapper.findByAuthorityId(authorityId);
	}
}
