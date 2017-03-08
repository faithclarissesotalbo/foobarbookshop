package com.foobarbookshop.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends Account implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "customer";
	public static final String COLUMN_ACCOUNTID = "accountid";

	private String accountid;
	
	public Customer(){
		super();
	}
	
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

}
