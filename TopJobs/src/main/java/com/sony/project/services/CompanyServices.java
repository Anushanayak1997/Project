package com.sony.project.services;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.sony.project.entities.CompanyDetailsEntity;
@Service
public class CompanyServices { 
	LinkedList<CompanyDetailsEntity> companyService = new LinkedList<CompanyDetailsEntity>();
  
	public void addCompanyDetails(CompanyDetailsEntity companyDetails)
	{
		companyService.add(companyDetails);
		int index=companyService.indexOf(companyDetails);
		companyService.get(index).setCompanyId(index);
	}

	public LinkedList<CompanyDetailsEntity> getCompany() {
		return companyService;
	}

}
