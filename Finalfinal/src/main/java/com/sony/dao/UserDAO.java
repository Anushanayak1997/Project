package com.sony.dao;

import java.util.LinkedList;
import java.util.List;

import com.sony.model.entity.UserEntity;

public interface UserDAO {
	
	public void addUser(UserEntity userenity);
	
	public List<UserEntity> getAllUsers();
}
