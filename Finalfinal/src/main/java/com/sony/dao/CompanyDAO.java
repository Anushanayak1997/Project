package com.sony.dao;

import java.util.List;

import com.sony.model.entity.Company;

public interface CompanyDAO {

	public Integer addCompany(Company company);
	
	public Company getCompanyById(int companyId);
	
	public List<Company> getAllCompany();
}
