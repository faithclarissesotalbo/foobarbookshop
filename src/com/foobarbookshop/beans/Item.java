package com.foobarbookshop.beans;

import java.io.Serializable;

public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "item";
	public static final String COLUMN_ITEMID = "itemid";
	public static final String COLUMN_TRANSACTIONID = "transactionid";	
	public static final String COLUMN_PRODUCTID = "productid";
	public static final String COLUMN_QUANTITY = "quantity";

	private String itemid;
	private String transactionid;
	private String productid;
	private String quantity;
	
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
}
