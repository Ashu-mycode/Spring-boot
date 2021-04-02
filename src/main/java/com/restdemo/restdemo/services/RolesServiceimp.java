
/*
 * RolesServiceImp class
 * implemented by IRolesService
 * All method implementation of IRolesService 
 * */

package com.restdemo.restdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restdemo.restdemo.entities.Roles;

import com.restdemo.restdemo.repository.RolesRepository;

@Service
public class RolesServiceimp implements IRolesService {
	
	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public List<Roles> getallRoles() {
		return rolesRepository.findAll();
	}

	@Override
	public Roles getRolesByrid(long rid) {
		return rolesRepository.findByrid(rid);
	}

	@Override
	public Roles addRoles(Roles roles) {
		rolesRepository.save(roles);
		return roles;
	}

	@Override
	public Roles updateRoles(Roles roles) {
		rolesRepository.save(roles);
		return roles;
	}

	@Override
	public void deleteRoles(long parselong) {
		Roles entity = rolesRepository.getOne(parselong);
		rolesRepository.delete(entity);
		
	}

}
