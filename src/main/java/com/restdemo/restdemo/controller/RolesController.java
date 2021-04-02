
/*
 * we create controller class
 * RolesController
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
import com.restdemo.restdemo.entities.Roles;
import com.restdemo.restdemo.services.IRolesService;

@RestController
@RequestMapping("/api")
public class RolesController {

	@Autowired
	private IRolesService iRolesService;
	
	@GetMapping("/allRoles")
	  public List<Roles> getallRoles() {
	    return this.iRolesService.getallRoles();
	  }
	
	@GetMapping("/Roles/{rid}")
	public ResponseEntity<Roles> get(@PathVariable Integer rid) {
        try {
            Roles roles = iRolesService.getRolesByrid(rid);
            return new ResponseEntity<Roles>(roles, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Roles>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PostMapping("/Roles")
	public Roles addRoles( @RequestBody Roles roles) {
		return this.iRolesService.addRoles(roles);
	}
	
	@PutMapping("/Roles/{rid}")
	public ResponseEntity<?> updateRoles(@RequestBody Roles roles, @PathVariable Integer rid) {
        try {
        	Roles existroles = iRolesService.getRolesByrid(rid);
        	roles.setRid(rid);            
        	iRolesService.addRoles(roles);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@DeleteMapping("/Roles/{rid}")
	public ResponseEntity<HttpStatus> deleteRoles(@PathVariable String rid){
		try {
			this.iRolesService.deleteRoles(Long.parseLong(rid));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
