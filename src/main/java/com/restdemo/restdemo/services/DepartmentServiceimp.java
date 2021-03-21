
/*
 * DepartmentServiceImp class
 * implemented by DepartmentService
 * All method implementation  
 * */


package com.restdemo.restdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restdemo.restdemo.entities.Department;
import com.restdemo.restdemo.repository.DepartmentRepository;

@Service
public class DepartmentServiceimp implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
     public DepartmentServiceimp() {
		
	}

	@Override
	public List<Department> getDepartments() {
		return departmentRepository.findAll();
		
	}

	@Override
	public Department getDepartments(long id) {
		return departmentRepository.findById(id);
	}

	@Override
	public Department addDepartment(Department department) {
		departmentRepository.save(department);
		return department;
	}

	@Override
	public Department updateDepartment(Department department) {
		departmentRepository.save(department);
		return department;
	}

	@Override
	public void deleteDepartment(long parselong) {
		Department entity = departmentRepository.getOne(parselong);
		departmentRepository.delete(entity);
		
	}

	

}
