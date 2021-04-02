
/*
 * we create AddressRepository interface using JPA
 * provide all features of CRUD Operations of AddressController
 * */

package com.restdemo.restdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restdemo.restdemo.entities.Address;


public interface AddressRepository extends JpaRepository<Address, Long>{

	List<Address> findAll();

	Address findByHno(long hno);
	
    

    Address save(Address address);

	void delete(Address entity);
	
}
