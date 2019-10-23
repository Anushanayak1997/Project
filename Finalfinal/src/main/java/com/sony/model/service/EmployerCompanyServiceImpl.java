package com.sony.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.EmployerCompanyDAO;

@Service
public class EmployerCompanyServiceImpl implements EmployerCompanyService {

	@Autowired
	EmployerCompanyDAO employercompanydao;
}
