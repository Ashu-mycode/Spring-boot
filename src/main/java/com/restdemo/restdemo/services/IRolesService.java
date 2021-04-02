
/*
 * we create IRolesService interface
 * provide all method which used in RolesController  
 * */

package com.restdemo.restdemo.services;

import java.util.List;


import com.restdemo.restdemo.entities.Roles;

public interface IRolesService {
	
	public List<Roles> getallRoles();

	public Roles getRolesByrid(long rid);
	
	public Roles addRoles(Roles roles);
	 
    public Roles updateRoles(Roles roles);
	 
	public void deleteRoles(long parseLong);
}
