
/*
 * we create DepartmentService Interface
 * provide all method which used in DepartmentController  
 * */


package com.restdemo.restdemo.services;

import java.util.List;

import com.restdemo.restdemo.entities.Department;


public interface DepartmentService {

    public List<Department> getallDepartments();
	
	public Department getDepartmentsbyid(long id);
	
	public Department addDepartment(Department department);
	

	public Department updateDepartment(Department department);

	public void deleteDepartment(long parseLong);
	
}
