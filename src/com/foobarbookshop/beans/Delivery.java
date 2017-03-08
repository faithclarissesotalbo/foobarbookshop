package com.foobarbookshop.beans;

import java.io.Serializable;

public class Delivery implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "delivery";
	public static final String COLUMN_ADDRESSID = "addressID";
	public static final String COLUMN_CUSTOMERID = "customerID";

	private String addressID;
	private String customerID;
	
	public String getAddressID() {
		return addressID;
	}
	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
}
