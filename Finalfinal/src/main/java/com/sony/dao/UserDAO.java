package com.sony.dao; 

import java.util.List;

import com.sony.model.dto.UserDTO;
import com.sony.model.entity.Login;
import com.sony.model.entity.User;

public interface UserDAO {
	
	public Integer addUser(User userenity);
	
	public List<UserDTO> getAllUsers();
	
	public User getUserById(int userId);
	
	public User authenticateuser(Login loginentity);

	public void editUser(User user);
}
