
/*
 * we create controller class
 * BookController
 * this class provide method which is used in Api
 * Get method,Post,Put and delete 
 * */


package com.restdemo.restdemo.secondDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.restdemo.restdemo.secondDB.entities.Book;
import com.restdemo.restdemo.secondDB.services.IBookService;


@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	private IBookService iBookService;

	@GetMapping("/bookname")
	  public List<Book> getallbooks() {
	    return this.iBookService.getallbooks();
	  }
	
	@PostMapping("/bookname")
	public Book addBooks( @RequestBody Book book) {
		return this.iBookService.addBooks(book);
	}
}
