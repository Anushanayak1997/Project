package com.sony.project.controllers;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.project.entities.EmployerCompanyEntity;
import com.sony.project.entities.LoginEntity;
import com.sony.project.entities.UserEntity;
import com.sony.project.services.UserService;

@RestController
public class User {

	@Autowired
	UserService userservice;

	@RequestMapping(value = "/getallusers")
	public List<UserEntity> getUsers() {
		return userservice.getUsers();
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public int registerUser(@RequestBody UserEntity userentity) {
		return userservice.registerUser(userentity);
	}

	@RequestMapping(value = "/loginuser")
	public Integer loginUser(@RequestBody LoginEntity loginentity) {
		//if (userservice.loginUser(loginentity)) {
//			return true;
//		}
//		return false;
		return userservice.loginUser(loginentity);
	}
}
