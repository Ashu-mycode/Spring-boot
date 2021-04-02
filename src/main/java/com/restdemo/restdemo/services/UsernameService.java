
/*
 * we create UserService interface
 * provide all method which used in UserController  
 * */

package com.restdemo.restdemo.services;

import java.util.List;

import com.restdemo.restdemo.entities.User;

public interface UsernameService {
	
	public List<User> getallUsers();
	
	public User getUsersbyid(long id);
	
	public List<User> getallUsersbystatus(Boolean status);
	
	public User addUser(User user);
	

	public User updateUser(User user);

	public void deleteUser(long parseLong);

}
