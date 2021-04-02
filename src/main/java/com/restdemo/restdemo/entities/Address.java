
/* we create entity in database
 * entity class Address 
 * table name address
 * */

package com.restdemo.restdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address")
public class Address {

	
	@Id
	@Column(name = "hno")
	private long hno;
	
	@Column(name = "Area")
	private String Area;
	
	@Column(name = "City")
	private String City;
	
	/*
	 * ManyToOne relationship
	 * Many address in one user
	 * */
	@ManyToOne
	@JsonIgnore
	private User user;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(long hno, String area, String city) {
		super();
		this.hno = hno;
		this.Area = area;
		this.City = city;
	}

	public long getHno() {
		return hno;
	}

	public void setHno(long hno) {
		hno = hno;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	@Override
	public String toString() {
		return "Address [Hno=" + hno + ", Area=" + Area + ", City=" + City + "]";
	}
	
	
	
	
}
