package com.foobarbookshop.beans;

import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "product";
	public static final String COLUMN_PRODUCTID = "productID";
	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_DESCRIPTION = "description";
	public static final String COLUMN_PRICE = "price";
	public static final String COLUMN_GENRE = "genre";
	public static final String COLUMN_TYPE = "type";
	public static final String COLUMN_STOCK = "stock";
	public static final String COLUMN_ACQUIREDATE = "acquiredate";

	private String productid;
	private String title;
	private String description;
	private String price;
	private String genre;
	private String type;
	private String stock;
	private String acquiredate;
	private int qty;
	
/*	public Product() {
		super();
	}*/
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getAcquiredate() {
		return acquiredate;
	}
	public void setAcquiredate(String acquiredate) {
		this.acquiredate = acquiredate;
	}
	

}
