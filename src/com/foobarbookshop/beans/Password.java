package com.foobarbookshop.beans;

import java.io.Serializable;

public class Password implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "password";
	public static final String COLUMN_ACCOUNTID = "accountID";
	public static final String COLUMN_PASSWORDID = "passwordID";
	public static final String COLUMN_HASHED = "hashedpw";
	public static final String COLUMN_ENCRYPTED =  "encryptedpw";
	public static final String COLUMN_TIMESTAMP = "timestamp";

	private String accountid;
	private String passwordid;
	private String hashedpw;
	private String encryptedpw;
	private String timestamp;
	
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getPasswordid() {
		return passwordid;
	}
	public void setPasswordid(String passwordid) {
		this.passwordid = passwordid;
	}
	public String getHashedpw() {
		return hashedpw;
	}
	public void setHashedpw(String hashedpw) {
		this.hashedpw = hashedpw;
	}
	public String getEncryptedpw() {
		return encryptedpw;
	}
	public void setEncryptedpw(String encryptedpw) {
		this.encryptedpw = encryptedpw;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
