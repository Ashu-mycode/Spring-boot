
/*we create entity in database
 * entity Department
 * */

package com.restdemo.restdemo.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "department")
public class Department {

	
	@Id
	@Column(name = "depid")
	private long depid;
	
	@Column(name = "dep_name")
	private String dep_name;
	
	

	@Column(name = "dep_loc")
	private String dep_loc;
	
	 
	
	/*
	 * One department can have many user
	 * OneTomany annotation used for one department
	 * Mapped in user table
	 * foreign key departments_depid referenced by depid in (department table) 
	 * */
	
	
	@OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "departments_depid")
	private List<User> user;
	
	//Getter and setter method 
	
	 public List<User> getUser() {
	        return user;
	    }
	 
	    public void setUser(List<User> user) {
	        this.user = user;
	    }
	 
	    
	    
	
	public Department(long depid, String dep_name, String dep_loc) {
		super();
		this.depid = depid;
		this.dep_name = dep_name;
		this.dep_loc = dep_loc;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getDepid() {
		return depid;
	}

	public void setDepid(long depid) {
		this.depid = depid;
	}

	public String getDep_name() {
		return dep_name;
	}

	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}

	public String getDep_loc() {
		return dep_loc;
	}

	public void setDep_loc(String dep_loc) {
		this.dep_loc = dep_loc;
	}

	@Override
	public String toString() {
		return "Department [depid=" + depid + ", dep_name=" + dep_name + ", dep_loc=" + dep_loc + "]";
	}
	
	
}
