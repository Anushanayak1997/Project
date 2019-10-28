package com.sony.controller;
 
import java.util.LinkedList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.service.UserService;
import com.sony.model.entity.User;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/getallusers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public boolean addUser(@RequestBody User userentity) {
		return userService.addUser(userentity);
	}

	@RequestMapping(value = "/loginuser")
	public boolean loginUser(@RequestBody User userentity) {
		return userService.authenticateuser(userentity);
	}
}
