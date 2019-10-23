package com.sony.model.service;


import java.util.LinkedList;
import java.util.List;

import com.sony.model.entity.UserEntity;

public interface UserService {

	public void addUser(UserEntity userenity);
	
	public List<UserEntity> getAllUsers();
}
