
/* we create entity in database
 * entity class Book 
 * table name book
 * */

package com.restdemo.restdemo.secondDB.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@Column(name = "bid")
	private long bid;
	
	@Column(name = "bookname")
	private String bookname;
	
	@Column(name ="status")
	private Boolean status;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(long bid, String bookname, Boolean status) {
		super();
		this.bid = bid;
		this.bookname = bookname;
		this.status = status;
	}

	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
		this.bid = bid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bookname=" + bookname + ", status=" + status + "]";
	}
	
	
}
