package com.sony.controller;
 
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.service.UserService;

import com.sony.model.entity.JobSeekerProject;

import com.sony.model.dto.UserDTO;

import com.sony.model.entity.Login;
import com.sony.model.entity.User;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/getallusers")
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/getuserbyid/{userId}")
	public UserDTO getUsersById(@PathVariable int userId) {
		return userService.getUserById(userId);
	}
	
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public Integer addUser(@RequestBody User userentity) {
		return userService.addUser(userentity);
	}

	@RequestMapping(value = "/edituser", method = RequestMethod.PUT)
	public void editUser(@RequestBody User user) {
		userService.editUser(user);
	}

	@RequestMapping(value = "/loginuser")
	public HashMap<String, Integer> loginUser(@RequestBody Login loginentity) {
		return userService.authenticateuser(loginentity);
	}
}
