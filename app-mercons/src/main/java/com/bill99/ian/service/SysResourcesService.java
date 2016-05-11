package com.bill99.ian.service;

import java.util.List;

import com.bill99.ian.entity.SysResources;

public interface SysResourcesService {
	
	public List<SysResources> findResourcesByAuthority(String authorityName);

}
