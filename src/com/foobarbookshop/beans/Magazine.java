package com.foobarbookshop.beans;

import java.io.Serializable;

public class Magazine extends Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "magazine";
	public static final String COLUMN_PRODUCTID = "productid";
	public static final String COLUMN_MONTH = "month";
	public static final String COLUMN_YEAR = "year";

	private String productid;
	private String month;
	private String year;
	
	public Magazine(){
		super();
	}
	
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
}
