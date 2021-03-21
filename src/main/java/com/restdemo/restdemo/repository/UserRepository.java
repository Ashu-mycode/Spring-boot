
/*
 * we create UserRepository interface using JPA
 * provide all features of mapping 
 * */


package com.restdemo.restdemo.repository;


import java.util.List;

//import org.springframework.stereotype.Repository;

import com.restdemo.restdemo.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAll();

	User findById(long id);

	User save(User user);

	void delete(User entity);
	
	

}
