package com.sony.model.service;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.CompanyDAO;
import com.sony.model.entity.CompanyEntity;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyDAO companydao;
	
	@Autowired
	HttpSession httpsession;
	
	public List<CompanyEntity> getAllCompany() {
		return companydao.getAllCompany();
	}
	
	public boolean addCompany(CompanyEntity company) {
		Integer companyId = companydao.addCompany(company);
		if(companyId != null) {
			httpsession.setAttribute("companyid", companyId);
			return true;
		}
		return false;
	}
}
