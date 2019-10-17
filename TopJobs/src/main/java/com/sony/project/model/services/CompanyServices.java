package com.sony.project.services;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.sony.project.entities.CompanyDetails;
@Service
public class CompanyServices {
	LinkedList<CompanyDetails> companyService = new LinkedList<CompanyDetails>();
 
	public void addCompanyDetails(CompanyDetails companyDetails)
	{
		companyService.add(companyDetails);
		int index=companyService.indexOf(companyDetails);
		companyService.get(index).setCompanyId(index);
//		System.out.println(index);
		
	}

	public LinkedList<CompanyDetails> getCompany() {
		
		return companyService;
		
	}

}
