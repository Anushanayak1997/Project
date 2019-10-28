package com.sony.model.service;

import java.util.LinkedList;
import java.util.List;

import com.sony.model.entity.Company;

public interface CompanyService {

	public boolean addCompany(Company company);
	
	public List<Company> getAllCompany();
	
	public Integer setCompanyIdSession(Company company);
}
