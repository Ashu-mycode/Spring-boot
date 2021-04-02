
/* we create entity in database
 * entity class Permission 
 * table name permission
 * */

package com.restdemo.restdemo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "permission")
public class Permission {

	@Id
	@Column(name = "p_id")
	private long p_id;

	@Column(name = "per_type")
	private String per_type;
	
	@Column(name = "symbol")
	private String symbol;

	 /*mapping ManytoMany for Roles and Permission table*/
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL, mappedBy = "permission")
	@JsonIgnore
	private List<Roles> roles; 
	
	 public List<Roles> getRoles() {
	        return roles;
	    }
	 
	    public void setRoles(List<Roles> roles) {
	        this.roles = roles;
	    }
	    
	
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Permission(long p_id, String per_type, String symbol) {
		super();
		this.p_id = p_id;
		this.per_type = per_type;
		this.symbol = symbol;
	}

	public long getP_id() {
		return p_id;
	}

	public void setP_id(long p_id) {
		this.p_id = p_id;
	}

	public String getPer_type() {
		return per_type;
	}

	public void setPer_type(String per_type) {
		this.per_type = per_type;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "Permission [p_id=" + p_id + ", per_type=" + per_type + ", symbol=" + symbol + "]";
	}
	
	
}
