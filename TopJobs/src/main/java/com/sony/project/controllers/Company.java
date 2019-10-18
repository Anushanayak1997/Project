package com.sony.project.controllers;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sony.project.entities.CompanyDetailsEntity;
import com.sony.project.services.CompanyServices;

@RestController
public class Company {

	CompanyServices companyServices;

	@RequestMapping(value = "/companydetails", method = RequestMethod.POST)
	public void addProducts(@RequestBody CompanyDetailsEntity companyDetails) {
		companyServices.addCompanyDetails(companyDetails);
	}

	@RequestMapping(value = "/companydetails")
	public LinkedList<CompanyDetailsEntity> details() {
		return companyServices.getCompany();
	}

	@RequestMapping(value = "/companydetails/{id}")
	public CompanyDetailsEntity getCompanyDetails(@PathVariable int id) {
		return companyServices.getCompanyDetails(id);
	}
	  @RequestMapping(value="/companydetails/update/{id}",method=RequestMethod.PUT)
      public void updateCompanyDetails(@PathVariable int id,@RequestBody CompanyDetailsEntity companyDetails)
      {
      	companyServices.updateCompanyDetails(id, companyDetails);
      }
      @RequestMapping(value="/companydetails/delete/{id}",method=RequestMethod.DELETE)
      public void deleteCompanyDetails(@PathVariable int id)
      {
      	companyServices.deleteCompanyDetails(id);
      }
}