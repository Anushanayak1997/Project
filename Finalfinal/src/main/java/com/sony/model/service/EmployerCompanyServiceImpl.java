package com.sony.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.EmployerCompanyDAO;
import com.sony.model.entity.EmployerCompany;

@Service
public class EmployerCompanyServiceImpl implements EmployerCompanyService {

	@Autowired
	EmployerCompanyDAO employercompanydao;

	public boolean addEmployerCompany(EmployerCompany employercompany) {
		if(employercompanydao.addEmployerCompany(employercompany) != null) {
			return true;
		}
		else {
			return false;
		}
	}
}
