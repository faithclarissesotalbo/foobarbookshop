package com.foobarbookshop.beans;

import java.io.Serializable;

public class DVD extends Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "dvd";
	public static final String COLUMN_PRODUCTID = "productid";
	public static final String COLUMN_DISKTYPE = "disktype";
	
	private String productid;
	private String disktype;
	
	public DVD(){
		super();
	}
	
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getDisktype() {
		return disktype;
	}
	public void setDisktype(String disktype) {
		this.disktype = disktype;
	}
	
	
}
