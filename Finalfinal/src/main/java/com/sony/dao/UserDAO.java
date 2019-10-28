package com.sony.dao; 
 
import java.util.LinkedList;
import java.util.List;

import com.sony.model.entity.User;

public interface UserDAO {
	
	public Integer addUser(User userenity);
	
	public List<User> getAllUsers();
	
	public User authenticateuser(User userentity);
}
