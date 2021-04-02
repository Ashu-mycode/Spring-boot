
/* we create entity in database
 * entity class User 
 * table name username
 * */

package com.restdemo.restdemo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Column(name ="status")
	private Boolean status;
	
	//@OneToMany(targetEntity = Department.class, cascade = CascadeType.ALL)
	//@JoinColumn(name = "userid_fk")
	
	/*
	 * ManyToOne relationship
	 * Many user in one department
	 * */
	
	@ManyToOne
	@JsonIgnore
	private Department departments;
	
	
	
	/*Mapping Address in User */
	
	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "User_id")
	private List<Address> address;
	
	 public List<Address> getAddress() {
	        return address;
	    }
	 
	    public void setAddress(List<Address> address) {
	        this.address = address;
	    }
	
	    
	    /*mapping ManytoMany for User and Roles table*/
	    
	    @ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	    @JoinTable(name = "User_role" ,
	         joinColumns = { @JoinColumn(name = "user_id")},
	         inverseJoinColumns = { @JoinColumn(name = "role_id")})
	    
	    private List<Roles> roles;   
	    
	    public List<Roles> getRoles() {
	        return roles;
	    }
	 
	    public void setRoles(List<Roles> roles) {
	        this.roles = roles;
	    }
	    
	    
	/*
	 * getter and setter method
	 * constructor
	 * toString method
	 * */
	
	public User(long id, String firstname, String middlename, String lastname, String email, Boolean status) {
		super();
		this.id = id;
		this.Firstname = firstname;
		this.Middlename = middlename;
		this.Lastname = lastname;
		this.email = email;
		this.status=status;
		
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
	
	public void setStatus(boolean status){
	    this.status=status;
	}

	public boolean hasStatus(){
	    return this.status;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", Firstname=" + Firstname + ", Middlename=" + Middlename + ", Lastname=" + Lastname
				+ ", email=" + email + ", status=" + status +"]";
	}
	
	
}
