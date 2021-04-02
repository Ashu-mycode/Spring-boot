
/*
 * we create DepartmentRepository interface using JPA
 * provide all features of CRUD Operation of DepartmentController 
 * */

package com.restdemo.restdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restdemo.restdemo.entities.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long> {

	List<Department> findAll();
	
	Department findById(long id);

	Department save(Department department);

	void delete(Department entity);
	
	
}
