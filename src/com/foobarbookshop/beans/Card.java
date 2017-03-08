package com.foobarbookshop.beans;

import java.io.Serializable;

public class Card implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "card";
	public static final String COLUMN_CARDID = "cardid";
	public static final String COLUMN_ACCOUNTID = "accountID";	
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_CARDNUM = "cardnum";	
	public static final String COLUMN_TYPE = "type";
	public static final String COLUMN_EXPIREDATE = "expiredate";	
		
	private String cardid;
	private String accountid;
	private String name;
	private String cardnum;
	private String type;
	private String expiredate;
	
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardnum() {
		return cardnum;
	}
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExpiredate() {
		return expiredate;
	}
	public void setExpiredate(String expiredate) {
		this.expiredate = expiredate;
	}
	
	
}
