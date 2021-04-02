
/*
 * UserServiceImp class
 * implemented by UserService
 * All method implementation of UserService 
 * */



package com.restdemo.restdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.restdemo.restdemo.entities.Department;
import com.restdemo.restdemo.entities.User;
//import com.restdemo.restdemo.repository.DepartmentRepository;
import com.restdemo.restdemo.repository.UserRepository;

@Service
public class UsernameServiceimp implements UsernameService {
	
	//List<User> list;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	public UsernameServiceimp() {
		
	}
	
	@Override
	public List<User> getallUsers(){
		return userRepository.findAll();
		
	}
	
	@Override
	public User getUsersbyid(long id) {
		return userRepository.findById(id);
	}
	
	
	
	@Override
	public User addUser(User user) {
	    userRepository.save(user);
		return user;
	}
	
	@Override
	public User updateUser(User user) {
		userRepository.save(user);
		return user;
	}
	
	@Override
	public void deleteUser(long parselong) {
		User entity = userRepository.getOne(parselong);
		userRepository.delete(entity);
		
	}

	@Override
	public List<User> getallUsersbystatus(Boolean status) {
		return userRepository.findAllByStatus(status);
	}

}
