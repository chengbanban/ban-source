package com.bill99.ian.service;

import java.util.List;

import com.bill99.ian.entity.SysAuthoritiesResources;

public interface SysAuthoritiesResourcesService {

	/**
	 * 获取所有的权限资源关系对应记录
	 * @return
	 */
	public List<SysAuthoritiesResources> getAll();
	
	public List<SysAuthoritiesResources> findByAuthorityId(String authorityId);
}
