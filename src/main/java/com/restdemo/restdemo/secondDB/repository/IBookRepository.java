
/*
 * we create IBookRepository interface using JPA
 * provide all features of CRUD Operations of BookController
 * */

package com.restdemo.restdemo.secondDB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.restdemo.restdemo.secondDB.entities.Book;

public interface IBookRepository extends JpaRepository<Book, Long>  {
	
	List<Book> findAll();
   
	Book save(Book book);
}
