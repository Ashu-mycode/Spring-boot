
/*
 * we create controller class
 * UserController
 * this class provide method which is used in Api
 * Get method,Post,Put and delete 
 * */



package com.restdemo.restdemo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.restdemo.restdemo.entities.Department;
import com.restdemo.restdemo.entities.User;
//import com.restdemo.restdemo.services.DepartmentService;
import com.restdemo.restdemo.services.UsernameService;

@RestController
@RequestMapping("/api")
public class UserController {

	//private UserRepository userRepository;
	
	@Autowired
	private UsernameService usernameService;
	
	
	
	@GetMapping("/username")
	  public List<User> getallUser() {
	    return this.usernameService.getallUsers();
	  }
	
	
	
	
	
	@GetMapping("/username/{id}")
	  //public User getUser(@PathVariable String id) {
		
		public ResponseEntity<User> get(@PathVariable Integer id) {
	        try {
	            User user = usernameService.getUsersbyid(id);
	            return new ResponseEntity<User>(user, HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
	    }
		
		//return this.usernameService.getUsers(Long.parseLong(id));
	//}
    
	
	@GetMapping("/status/{status}")
	public List<User> get(@PathVariable Boolean status) {
        return usernameService.getallUsersbystatus(status);
    }
	
	
	@PostMapping("/username")
	public User addUser( @RequestBody User user) {
		return this.usernameService.addUser(user);
	}
	
	
	
	
	@PutMapping("/username/{id}")
	//public User updateUser(@RequestBody User user) {
		
		public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Integer id) {
	        try {
	            User existUser = usernameService.getUsersbyid(id);
	            user.setId(id);            
	            usernameService.addUser(user);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
		
		//return this.usernameService.updateUser(user);
	//}
  
	@DeleteMapping("/username/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id){
		try {
			this.usernameService.deleteUser(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
