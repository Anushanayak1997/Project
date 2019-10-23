package com.sony.model.service;

import java.util.List;

import com.sony.model.entity.UserEntity;

public interface UserService {

	public boolean addUser(UserEntity userenity);
	
	public List<UserEntity> getAllUsers();
	public boolean authenticateuser(UserEntity userentity);
}
