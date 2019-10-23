package com.sony.model.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.UserDAO;
import com.sony.model.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userdao;

	public boolean addUser(UserEntity userenity) {
		return userdao.addUser(userenity);
	}

	public List<UserEntity> getAllUsers() {
		return userdao.getAllUsers();
	}

}
