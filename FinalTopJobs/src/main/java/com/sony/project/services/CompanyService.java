package com.sony.project.services;

import com.sony.project.entities.CompanyDetailsEntity;
import com.sony.project.entities.JobPostEntity;

public interface CompanyService {
	
	//public void addCompanyName(String companyname);
	
	public Integer addCompanyDetails(CompanyDetailsEntity companyDetails);
	
	public CompanyDetailsEntity getCompanyDetails(int id);
	
	public void updateCompanyDetails(int id, CompanyDetailsEntity obj);
	
	public void deleteCompanyDetails(int id);
	
	public Integer addJobPost(JobPostEntity jobpostentity);
}
