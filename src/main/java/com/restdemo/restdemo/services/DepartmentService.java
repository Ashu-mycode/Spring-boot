
/*
 * we create DepartmentService
 * provide all method which used in controller  
 * */


package com.restdemo.restdemo.services;

import java.util.List;

import com.restdemo.restdemo.entities.Department;


public interface DepartmentService {

    public List<Department> getDepartments();
	
	public Department getDepartments(long id);
	
	public Department addDepartment(Department department);
	

	public Department updateDepartment(Department department);

	public void deleteDepartment(long parseLong);
	
}
