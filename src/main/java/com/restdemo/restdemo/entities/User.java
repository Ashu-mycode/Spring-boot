
/*we create entity in database
 * entity username
 * */

package com.restdemo.restdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*Entity Annotation*/

@Entity
@Table(name = "username")
public class User {

	/*
	 * Auto increment Id
	 * @param id
	 * @param String parameters
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "Firstname")
	private String Firstname;
	
	@Column(name = "Middlename")
	private String Middlename;
	
	@Column(name = "Lastname")
	private String Lastname;
	
	@Column(name = "email")
	private String email;
	
	
	//@OneToMany(targetEntity = Department.class, cascade = CascadeType.ALL)
	//@JoinColumn(name = "userid_fk")
	
	/*
	 * ManyToOne relationship
	 * Many user in one department
	 * */
	
	@ManyToOne
	@JsonIgnore
	private Department departments;
	/* public Department getDepartment() {
        return departments;
    }

    public void setDepartment(Department departments) {
        this.departments = departments;
    }*/
	
	/*
	 * getter and setter method
	 * constructor
	 * toString method
	 * */
	
	public User(long id, String firstname, String middlename, String lastname, String email) {
		super();
		this.id = id;
		this.Firstname = firstname;
		this.Middlename = middlename;
		this.Lastname = lastname;
		this.email = email;
		
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getMiddlename() {
		return Middlename;
	}
	public void setMiddlename(String middlename) {
		Middlename = middlename;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Firstname=" + Firstname + ", Middlename=" + Middlename + ", Lastname=" + Lastname
				+ ", email=" + email + "]";
	}
	
	
}
