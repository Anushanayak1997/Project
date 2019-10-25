package com.sony.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.EmployerCompanyDAO;
import com.sony.dao.UserDAO;
import com.sony.model.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userdao;
	
	@Autowired
	EmployerCompanyDAO employercompanydao;

	@Autowired
	HttpSession httpsession;

	public boolean addUser(UserEntity userenity) {
	
		Integer userId = userdao.addUser(userenity);
		if(userId != null) {
			httpsession.setAttribute("userid", userId);
			return true;
		}
		return false;
	}

	public List<UserEntity> getAllUsers() {
		return userdao.getAllUsers();
	}

	public boolean authenticateuser(UserEntity userentity)
	{
		boolean status;
		Integer companyid;
		UserEntity user = userdao.authenticateuser(userentity); 
		if( user != null) {
			companyid = employercompanydao.getCompanyId(user.getUserID());
			httpsession.setAttribute("userid", user.getUserID());
			httpsession.setAttribute("companyid", companyid);
			status = true;
		} else {
			status = false;
		}
		return status;
	}	
}
