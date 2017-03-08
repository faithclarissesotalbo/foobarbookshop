package com.foobarbookshop.beans;

import java.io.Serializable;

public class Login implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "login";
	public static final String COLUMN_ACCOUNTID = "accountID";
	public static final String COLUMN_LOGINID = "loginID";
	public static final String COLUMN_STATUS = "status";
	public static final String COLUMN_TIMESTAMP = "timestamp";
	
	private String accountid;
	private String loginid;
	private String status;
	private String timestamp;
	
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
