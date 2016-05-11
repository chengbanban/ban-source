package com.bill99.ian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.ian.dao.SysResourcesMapper;
import com.bill99.ian.entity.SysResources;
import com.bill99.ian.service.SysResourcesService;

@Service("sysResourcesService")
public class SysResourcesServiceImpl implements SysResourcesService {

	@Autowired
	private SysResourcesMapper resourcesMapper;
	
	@Override
	public List<SysResources> findResourcesByAuthority(String authorityName) {
		//TODO
		return null;
	}

}
