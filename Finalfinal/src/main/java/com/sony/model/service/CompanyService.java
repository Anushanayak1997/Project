package com.sony.model.service;


import java.util.List;

import com.sony.model.dto.CompanyDTO;
import com.sony.model.entity.Company;
import com.sony.model.entity.User;

public interface CompanyService {

	public Integer addCompany(CompanyDTO companydto);
	
	public List<CompanyDTO> getAllCompany();
	
	public Integer setCompanyIdSession(CompanyDTO companydto);

	public Company getCompanyById(int companyId);

}
