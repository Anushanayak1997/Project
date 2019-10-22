package com.sony.project.services;

import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.project.entities.EmployerCompanyEntity;

@Service
public class EmployerCompanyService {
	
	@Autowired
	HttpSession httpSession;

	LinkedList<EmployerCompanyEntity> employercompanylist = new LinkedList<EmployerCompanyEntity>();
	
	public LinkedList<EmployerCompanyEntity> getEmployerCompany(){
		return employercompanylist;
	}
	
	public void addEmployerCompany() {
		int userid = (Integer) httpSession.getAttribute("userid");
		int companyid = (Integer) httpSession.getAttribute("companyid");
		EmployerCompanyEntity employercompany = new EmployerCompanyEntity(userid, companyid);
		employercompanylist.add(employercompany);
	}
	
	public Integer setSessionCompanyId(int userId) {
		Iterator<EmployerCompanyEntity> iterator = employercompanylist.iterator();
		while(iterator.hasNext()) {
			EmployerCompanyEntity employercompany = iterator.next();
			if(employercompany.getUserId() == userId) {
				return employercompany.getCompanyId();
			}
		}
		return -1;
	}
}
