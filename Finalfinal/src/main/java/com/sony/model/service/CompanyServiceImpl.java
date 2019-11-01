package com.sony.model.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.CompanyDAO;
import com.sony.model.dto.CompanyDTO;
import com.sony.model.entity.Company;
import com.sony.model.entity.EmployerCompany;

@Service

public class CompanyServiceImpl implements CompanyService{
	 private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);



	@Autowired
	CompanyDAO companydao;

	@Autowired
	HttpSession httpsession;

	@Autowired
	EmployerCompanyService employerservice;

	public List<Company> getAllCompany() {
		return companydao.getAllCompany();
	}
	public Integer addCompany(CompanyDTO companydto) {
		Company company = new Company(companydto.getCompanyId(), companydto.getCompanyName(),
				companydto.getCompanyDescription(), companydto.getEstablishmentDate(), companydto.getWebsiteUrl(),
				companydto.getHeadquarter(), companydto.getSpecialities(), companydto.getIndustry(),
				companydto.getType());
		Integer companyId = companydao.addCompany(company);
		if (companyId != null) {
//			httpsession.setAttribute("companyid", companyId);
//			Integer userid = (Integer) httpsession.getAttribute("userid");
//			Integer companyid = (Integer) httpsession.getAttribute("companyid");
			EmployerCompany employercompanyentity = new EmployerCompany(companydto.getUserId(), companyId);
			employerservice.addEmployerCompany(employercompanyentity);
			return companyId;
		}
		return null;
	}	

	public Integer setCompanyIdSession(CompanyDTO companydto) {
		Integer companyid = companydto.getCompanyId();
		if (companyid != null) {
//			Integer userid = (Integer) httpsession.getAttribute("userid");
//			httpsession.setAttribute("companyid", companyid);
			logger.info("User id" + companydto.getUserId());
			EmployerCompany employercompanyentity = new EmployerCompany(companydto.getUserId(), companydto.getCompanyId());
			employerservice.addEmployerCompany(employercompanyentity);
		}
		return companyid;
	}
}
