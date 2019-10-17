package com.sony.project.controllers;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.sony.project.entities.CompanyDetails;
import com.sony.project.services.CompanyServices;
 
@RestController
public class Company {

	@Autowired
	CompanyServices companyServices;

	@RequestMapping(value = "/companydetails", method = RequestMethod.POST)
	public void addProducts(@RequestBody CompanyDetails companyDetails) {
             companyServices.addCompanyDetails(companyDetails);
	}
	@RequestMapping(value="/companies")
	public LinkedList<CompanyDetails> details()
	{
		return companyServices.getCompany();
	}
	
}
