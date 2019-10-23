package com.sony.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.UserDAO;
import com.sony.model.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService {
	 
	@Autowired
	private UserDAO userDao;
	
	UserDAO userdao;

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
		return userDao.getAllUsers();
	}

	public boolean authenticateuser(UserEntity userentity)
	{

		return userdao.authenticateuser(userentity);
	}	
}
