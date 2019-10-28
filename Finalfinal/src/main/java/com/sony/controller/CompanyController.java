package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.entity.Company;
import com.sony.model.service.CompanyService;

@RestController
public class CompanyController {
 
	@Autowired
	CompanyService companyservice;

	@RequestMapping(value = "/getallcompany")
	public List<Company> getAllCompany() {
		return companyservice.getAllCompany();
	}

	@RequestMapping(value = "/addcompanydetails", method = RequestMethod.POST)
	public boolean addCompany(@RequestBody Company company) {
		return(companyservice.addCompany(company));
	}
	
	@RequestMapping(value = "/setcompanyid", method = RequestMethod.POST)
	public Integer setCompanyIdSession(@RequestBody Company company) {
		return (companyservice.setCompanyIdSession(company));
	}
}
