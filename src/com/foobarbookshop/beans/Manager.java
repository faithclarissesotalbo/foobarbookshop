package com.foobarbookshop.beans;

import java.io.Serializable;

public class Manager implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "manager";
	public static final String COLUMN_ACCOUNTID = "accountID";
	public static final String COLUMN_POSIITON = "position";
	public static final String COLUMN_PRODUCTTYPE = "producttype";

	private String accountID;
	private String position;
	private String producttype;
	
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getProducttype() {
		return producttype;
	}
	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}
	
	
}
