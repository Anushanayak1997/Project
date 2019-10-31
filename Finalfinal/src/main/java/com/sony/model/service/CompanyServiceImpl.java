package com.sony.model.service;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.CompanyDAO;
import com.sony.model.entity.Company;
import com.sony.model.entity.EmployerCompany;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyDAO companydao;
	
	@Autowired
	HttpSession httpsession;
	
	@Autowired
	EmployerCompanyService employerservice;
	
	public List<Company> getAllCompany() {
		return companydao.getAllCompany();
	}
	
	public boolean addCompany(Company company) {
			Integer companyId = companydao.addCompany(company);
			if(companyId != null) {
				httpsession.setAttribute("companyid", companyId);
				Integer userid = (Integer) httpsession.getAttribute("userid");
				Integer companyid = (Integer) httpsession.getAttribute("companyid");
				EmployerCompany employercompanyentity = new EmployerCompany(userid, companyid);
				employerservice.addEmployerCompany(employercompanyentity);
				return true;
			}
			return false;
	}
	
	public Integer setCompanyIdSession(Company company) {
		Integer companyid = company.getCompanyId();
		if(companyid != null) {
			Integer userid = (Integer) httpsession.getAttribute("userid");
			httpsession.setAttribute("companyid", companyid);
			EmployerCompany employercompanyentity = new EmployerCompany(userid, companyid);
			employerservice.addEmployerCompany(employercompanyentity);
		}
		return companyid;
	}
}
