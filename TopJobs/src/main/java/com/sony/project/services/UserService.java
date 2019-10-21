package com.sony.project.services;

import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpSession;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	CompanyServices companyservice;

	public int registerUser(UserEntity userentity) {
		users.add(userentity);
		int index = users.indexOf(userentity);
		users.get(index).setUserID(index);
		httpSession.setAttribute("userid", userentity.getUserID());
		return companyservice.addCompanyName(userentity.getCompanyName());
	}
	
	public boolean loginUser(LoginEntity loginentity) {
		Iterator<UserEntity> iterator = users.iterator();
		while(iterator.hasNext()) {
			UserEntity userentity = iterator.next();
			if(userentity.getEmailID().equals(loginentity.getEmail()) && userentity.getPassword().equals(loginentity.getPassword())) {
				httpSession.setAttribute("userid", userentity.getUserID());
				employercompany.setSessionCompanyId(userentity.getUserID());
				return true;
			}
		}
		return false;
	}
	
	public LinkedList<UserEntity> getUsers() {
		return users;
	}

}
