
/* we create entity in database
 * entity class Roles 
 * table name roles
 * */

package com.restdemo.restdemo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
public class Roles {
	
	@Id
	@Column(name = "r_id")
	private long rid;

	@Column(name = "role_name")
	private String role_name;

	 /*mapping ManytoMany for User and Roles table*/
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL, mappedBy = "roles")
	@JsonIgnore
	private List<User> user; 
	
	 public List<User> getUser() {
	        return user;
	    }
	 
	    public void setUser(List<User> user) {
	        this.user = user;
	    }
	    
	
	    /*mapping ManytoMany for Roles and Permission table*/ 
	    
	    @ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	    @JoinTable(name = "role_permission" ,
	         joinColumns = { @JoinColumn(name = "role_id")},
	         inverseJoinColumns = { @JoinColumn(name = "per_id")})
	    private List<Permission> permission;   
	    
	    public List<Permission> getPermission() {
	        return permission;
	    }
	 
	    public void setPermission(List<Permission> permission) {
	        this.permission = permission;
	    }
	    
	    
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(long rid, String role_name) {
		super();
		this.rid = rid;
		this.role_name = role_name;
	}

	public long getRid() {
		return rid;
	}

	public void setRid(long rid) {
		this.rid = rid;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "Roles [rid=" + rid + ", role_name=" + role_name + "]";
	}
	
	
}
