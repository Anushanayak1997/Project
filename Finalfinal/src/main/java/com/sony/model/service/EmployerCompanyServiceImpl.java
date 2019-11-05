package com.sony.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.EmployerCompanyDAO;
import com.sony.model.entity.EmployerCompany;

@Service
public class EmployerCompanyServiceImpl implements EmployerCompanyService {

	@Autowired
	EmployerCompanyDAO employercompanydao;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployerCompanyServiceImpl.class);

	public boolean addEmployerCompany(EmployerCompany employercompany) {
		logger.info("NNNNNNNN" + employercompany.getUserId());
		if(employercompanydao.addEmployerCompany(employercompany) != null) {
			return true;
		}
		else {
			return false;
		}
	}
}
