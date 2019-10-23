package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.entity.CompanyEntity;
import com.sony.model.service.CompanyService;

@RestController
public class Company {
 
	@Autowired
	CompanyService companyservice;

	@RequestMapping(value = "/getallcompany")
	public List<CompanyEntity> getAllCompany() {
		return companyservice.getAllCompany();
	}

	@RequestMapping(value = "/addcompanydetails", method = RequestMethod.POST)
	public boolean addCompany(@RequestBody CompanyEntity company) {
		return companyservice.addCompany(company);
	}
}
