package com.bill99.ian.service;

import java.util.List;

import com.bill99.ian.entity.SysAuthorities;

public interface SysAuthoritiesService {
	
	public List<SysAuthorities> getAll();
	
	public SysAuthorities findById(String authorityId);
}
