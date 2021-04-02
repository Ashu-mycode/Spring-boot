
/*
 * we create IBookService interface
 * provide all method which used in BookController  
 * */

package com.restdemo.restdemo.secondDB.services;

import java.util.List;


import com.restdemo.restdemo.secondDB.entities.Book;

public interface IBookService {

	public List<Book> getallbooks();
	
	public Book addBooks(Book book);
}
