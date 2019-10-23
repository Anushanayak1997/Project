package com.sony.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.service.UserService;
import com.sony.model.entity.UserEntity;

@RestController
public class User {
	
	@Autowired
	UserService userservice;
	
	@RequestMapping(value = "/getallusers")
	public List<UserEntity> getAllUsers() {
		return userservice.getAllUsers();
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public void addUser(@RequestBody UserEntity userentity) {
		userservice.addUser(userentity);
	}
	@RequestMapping(value = "/loginuser")
	public boolean loginUser(@RequestBody UserEntity userentity) {
		return userservice.authenticateuser(userentity);
	}
}
