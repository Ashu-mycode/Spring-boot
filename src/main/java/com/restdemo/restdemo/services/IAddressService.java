
/*
 * we create IAddressService interface
 * provide all method which used in AddressController  
 * */

package com.restdemo.restdemo.services;

import java.util.List;

import com.restdemo.restdemo.entities.Address;



public interface IAddressService {
	
	 public List<Address> getallAddress();

	 public Address getAddressByHno(long hno);
	 
	 public Address addAddress(Address address);
	 
	 public Address updateAddress(Address address);
	 
	 public void deleteAddress(long parseLong);
}
