package com.sony.model.service;


import java.util.List;

import com.sony.model.dto.CompanyDTO;
import com.sony.model.entity.Company;


public interface CompanyService {

	public Integer addCompany(CompanyDTO companydto);
	
	public List<Company> getAllCompany();
	
	public Integer setCompanyIdSession(CompanyDTO companydto);

	public Company getCompanyById(int companyId);

}
