
/*
 * AddressServiceImp class
 * implemented by IAddressService
 * All method implementation of IAddressService 
 * */

package com.restdemo.restdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restdemo.restdemo.entities.Address;
import com.restdemo.restdemo.repository.AddressRepository;

@Service
public class AddressServiceimp implements IAddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
     public AddressServiceimp() {
		
	}

    @Override
 	public List<Address> getallAddress(){
 		return addressRepository.findAll();
 		
 	}

	@Override
	public Address getAddressByHno(long hno) {
		return addressRepository.findByHno(hno);
		
	}

	@Override
	public Address addAddress(Address address) {
		addressRepository.save(address);
		return address;
		
	}

	@Override
	public Address updateAddress(Address address) {
		addressRepository.save(address);
		return address;
		
	}

	@Override
	public void deleteAddress(long parselong) {
		Address entity = addressRepository.getOne(parselong);
		addressRepository.delete(entity);
		
	}

}
