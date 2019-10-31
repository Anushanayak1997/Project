package com.sony.model.service;

import java.util.List;

import com.sony.model.entity.User;

public interface UserService {

	public boolean addUser(User userenity);
	
	public List<User> getAllUsers();
	
	public boolean authenticateuser(User userentity);
}
