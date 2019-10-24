package com.sony.dao;

import java.util.List;

import com.sony.model.entity.CompanyEntity;

public interface CompanyDAO {

	public Integer addCompany(CompanyEntity company);
	
	public CompanyEntity getCompanyById(int companyId);
	
	public List<CompanyEntity> getAllCompany();
}
