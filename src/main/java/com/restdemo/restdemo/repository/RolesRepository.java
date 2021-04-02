
/*
 * we create RolesRepository interface using JPA
 * provide all features of CRUD Operations of RolesController
 * */

package com.restdemo.restdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.restdemo.restdemo.entities.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long>{

	List<Roles> findAll();
	
	Roles findByrid(long rid);
	
	 Roles save(Roles roles);
	 
	 void delete(Roles entity);
}
