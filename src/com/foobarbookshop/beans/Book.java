package com.foobarbookshop.beans;

import java.io.Serializable;

public class Book extends Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "book";
	public static final String COLUMN_PRODUCTID = "productid";
	public static final String COLUMN_AUTHOR = "author";

	private String productid;
	private String author;
	
	public Book(){
		super();
	}
	
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
