package com.foobarbookshop.beans;

import java.io.Serializable;

public class Transaction implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "transaction";
	public static final String COLUMN_TRANSACTIONID = "transactionID";
	public static final String COLUMN_TIMESTAMP = "timestamp";
	public static final String COLUMN_TRANSACTIONLIST = "transactionlist";

	private String transactionID;
	private String timestamp;
	private String transactionlist;
	
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getTransactionlist() {
		return transactionlist;
	}
	public void setTransactionlist(String transactionlist) {
		this.transactionlist = transactionlist;
	}
	
	
}
