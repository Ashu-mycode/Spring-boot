
/*
 * BookServiceImp class
 * implemented by IBookService
 * All method implementation of IBookService 
 * */

package com.restdemo.restdemo.secondDB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.restdemo.restdemo.secondDB.entities.Book;
import com.restdemo.restdemo.secondDB.repository.IBookRepository;

public class BookServiceimp implements IBookService {

	@Autowired
	private IBookRepository iBookRepository;
	
	
	
	public BookServiceimp() {
		
	}
	
	@Override
	public List<Book> getallbooks() {
		return iBookRepository.findAll();
	}

	@Override
	public Book addBooks(Book book) {
		iBookRepository.save(book);
			return book;
	}
	

}
