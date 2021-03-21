
/*
 * we create controller class
 * DepartmentController
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

import com.restdemo.restdemo.entities.Department;

import com.restdemo.restdemo.services.DepartmentService;


@RestController
@RequestMapping("/api")
public class DepartmentController {
	
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/deptname")
	  public List<Department> getDepartment() {
	    return this.departmentService.getDepartments();
	  }
	
	@GetMapping("/deptname/{id}")
	public ResponseEntity<Department> get(@PathVariable Integer id) {
        try {
        	Department department = departmentService.getDepartments(id);
            return new ResponseEntity<Department>(department, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PostMapping("/deptname")
	public Department addDepartment( @RequestBody Department department) {
		return this.departmentService.addDepartment(department);
	}
	
	
	@PutMapping("/deptname/{id}")
	public ResponseEntity<?> updateDepartment(@RequestBody Department department, @PathVariable Integer id) {
        try {
        	Department existDepartment = departmentService.getDepartments(id);
        	department.setDepid(id);            
        	departmentService.addDepartment(department);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@DeleteMapping("/deptname/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id){
		try {
			this.departmentService.deleteDepartment(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
