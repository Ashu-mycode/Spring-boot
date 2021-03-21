
/*
 * we create UserService
 * provide all method which used in controller  
 * */

package com.restdemo.restdemo.services;

import java.util.List;

import com.restdemo.restdemo.entities.User;

public interface UsernameService {
	
	public List<User> getUsers();
	
	public User getUsers(long id);
	
	public User addUser(User user);
	

	public User updateUser(User user);

	public void deleteUser(long parseLong);

}
