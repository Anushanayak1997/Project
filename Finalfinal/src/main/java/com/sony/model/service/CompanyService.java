package com.sony.model.service;

import java.util.LinkedList;
import java.util.List;

import com.sony.model.entity.CompanyEntity;

public interface CompanyService {

	public boolean addCompany(CompanyEntity company);
	
	public List<CompanyEntity> getAllCompany();
}
