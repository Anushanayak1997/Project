package com.sony.controller;
 
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.service.UserService;


import com.sony.model.dto.UserDTO;

import com.sony.model.entity.Login;
import com.sony.model.entity.User;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/getallusers")
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/getuserbyid/{userId}")
	public UserDTO getUsersById(@PathVariable int userId) {
		return userService.getUserById(userId);
	}
	
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public Integer addUser(@RequestBody UserDTO userdto) {
		logger.info("UserEntity",userdto);
		return userService.addUser(userdto);
	}

	@RequestMapping(value = "/edituser", method = RequestMethod.PUT)
	public void editUser(@RequestBody User user) {
		userService.editUser(user);
	}

	@RequestMapping(value = "/loginuser")
	public HashMap<String, Integer> loginUser(@RequestBody Login loginentity) {
		return userService.authenticateuser(loginentity);
	}
	
	@RequestMapping(value = "/uploadResume", method = RequestMethod.PUT)
	public Integer uploadImage2(@RequestBody UserDTO userdto) {
		try {
			// This will decode the String which is encoded by using Base64
			// byte[] resumeByte = Base64.getDecoder().decode(userdto.getUserimage());
			return userService.addResume(userdto);
		} catch (Exception e) {
			return -1;
		}
	}
	
	@RequestMapping(value = "/download/{userId}")
	public Map<String, String> getResume(@PathVariable int userId) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Image", userService.getResume(userId));
		return map;	
	}
	
//	@RequestMapping(value = "/download/{avatarId}")
//	public Map<String, String> getImage(@PathVariable int avatarId){
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("Image", companyservice.getImage(avatarId));
//		return map;	
//	}
}
