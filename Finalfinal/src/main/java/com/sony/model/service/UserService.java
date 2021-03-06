package com.sony.model.service;

import java.util.HashMap;
import java.util.List;

import com.sony.model.dto.UserDTO;
import com.sony.model.entity.Login;
import com.sony.model.entity.User;

public interface UserService {

	public Integer addUser(UserDTO useredto);

	public List<UserDTO> getAllUsers();

	public UserDTO getUserById(int userId);

	public HashMap<String, Integer> authenticateuser(Login loginentity);

	public void editUser(User user);

	public Integer addResume(UserDTO userdto);
	
	public String getResume(int userId);
}
