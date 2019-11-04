package com.sony.model.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.controller.CompanyController;
import com.sony.dao.EmployerCompanyDAO;
import com.sony.dao.UserDAO;
import com.sony.model.dto.UserDTO;
import com.sony.model.entity.Login;
import com.sony.model.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	@Autowired
	UserDAO userdao;

	@Autowired
	EmployerCompanyDAO employercompanydao;

	@Autowired
	HttpSession httpsession;

	public Integer addUser(User userenity) {
		Integer userId = userdao.addUser(userenity);
		if (userId != null) {
			httpsession.setAttribute("userid", userId);
		
			return userId;
		}
		return null;
	}

	public List<UserDTO> getAllUsers() {
		return userdao.getAllUsers();
	}

	public HashMap<String, Integer> authenticateuser(Login loginentity) {
		boolean status;
		Integer companyid;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		User user = userdao.authenticateuser(loginentity);
		if (user != null) {
			logger.info("Inside user");
			if (user.getUserType().equalsIgnoreCase("Employer")) {
				logger.info("USer" + user);
				companyid = employercompanydao.getCompanyId(user.getUserID());
//				httpsession.setAttribute("userid", user.getUserID());
//				httpsession.setAttribute("companyid", companyid);
				map.put("userId", user.getUserID());
				map.put("companyId", companyid);
				status = true;
			}
			else {
				map.put("userId", user.getUserID());
			}
			return map;

		} else {
			status = false;
			return null;
		}
//		return map;
	}

	public User getUserById(int userId) {
		return userdao.getUserById(userId);
	}

	public void editUser(User user) {
		userdao.editUser(user);
		
	}
}
