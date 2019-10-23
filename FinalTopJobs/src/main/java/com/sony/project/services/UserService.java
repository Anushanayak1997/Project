package com.sony.project.services;

import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpSession;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.project.entities.EmployerCompanyEntity;
import com.sony.project.entities.LoginEntity;
import com.sony.project.entities.UserEntity;

@Service
public class UserService {

	LinkedList<UserEntity> users = new LinkedList<UserEntity>();
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	EmployerCompanyService employercompany;
	
	@Autowired
	CompanyServicesImpl companyservice;

	public void registerUser(UserEntity userentity) {
		users.add(userentity);
		int index = users.indexOf(userentity);
		users.get(index).setUserID(index);
		httpSession.setAttribute("userid", userentity.getUserID());
		//companyservice.addCompanyName(userentity.getCompanyName());
	}
	
	public Integer loginUser(LoginEntity loginentity) {
		Iterator<UserEntity> iterator = users.iterator();
		while(iterator.hasNext()) {
			UserEntity userentity = iterator.next();
			if(userentity.getEmailID().equals(loginentity.getEmail()) && userentity.getPassword().equals(loginentity.getPassword())) {
				int companyid = employercompany.setSessionCompanyId(userentity.getUserID());
				httpSession.setAttribute("userid", userentity.getUserID());
				httpSession.setAttribute("companyid",companyid);
				return (Integer)httpSession.getAttribute("userid");
			}
		}
		return (Integer)httpSession.getAttribute("userid");
	}
	
	public LinkedList<UserEntity> getUsers() {
		return users;
	}

}
