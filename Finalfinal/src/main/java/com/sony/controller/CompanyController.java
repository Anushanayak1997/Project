package com.sony.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.dto.CompanyDTO;
import com.sony.model.entity.Company;
import com.sony.model.service.CompanyService;

@RestController
public class CompanyController {
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
 
	@Autowired
	CompanyService companyservice;

	@RequestMapping(value = "/getallcompany")
	public List<Company> getAllCompany() {
		return companyservice.getAllCompany(); 
	}

	@RequestMapping(value = "/addcompanydetails", method = RequestMethod.POST)
	public Integer addCompany(@RequestBody CompanyDTO companydto) {
		return(companyservice.addCompany(companydto));
	}
	
	@RequestMapping(value = "/setcompanyid", method = RequestMethod.POST) 
	public Integer setCompanyIdSession(@RequestBody CompanyDTO companydto) {
		return (companyservice.setCompanyIdSession(companydto));
	}
}
