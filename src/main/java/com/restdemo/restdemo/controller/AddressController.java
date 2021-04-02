
/*
 * we create controller class
 * AddressController
 * this class provide method which is used in Api
 * Get method,Post,Put and delete 
 * */

package com.restdemo.restdemo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restdemo.restdemo.entities.Address;
import com.restdemo.restdemo.services.IAddressService;

@RestController
@RequestMapping("/api")
public class AddressController {
	
	@Autowired
	private IAddressService iaddressService;
	
	@GetMapping("/allAddress")
	  public List<Address> getallAddress() {
	    return this.iaddressService.getallAddress();
	  }

	
	@GetMapping("/Address/{hno}")
		public ResponseEntity<Address> get(@PathVariable Integer hno) {
	        try {
	            Address address = iaddressService.getAddressByHno(hno);
	            return new ResponseEntity<Address>(address, HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	@PostMapping("/Address")
	public Address addAddress( @RequestBody Address address) {
		return this.iaddressService.addAddress(address);
	}
	
	@PutMapping("/Address/{hno}")
	public ResponseEntity<?> updateAddress(@RequestBody Address address, @PathVariable Integer hno) {
        try {
        	Address existaddress = iaddressService.getAddressByHno(hno);
        	address.setHno(hno);            
        	iaddressService.addAddress(address);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@DeleteMapping("/Address/{hno}")
	public ResponseEntity<HttpStatus> deleteAddress(@PathVariable String hno){
		try {
			this.iaddressService.deleteAddress(Long.parseLong(hno));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
