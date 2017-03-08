package com.foobarbookshop.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "account";
	public static final String COLUMN_ACCOUNTID = "accountID";
	public static final String COLUMN_LASTNAME = "lastname";
	public static final String COLUMN_FIRSTNAME = "firstname";
	public static final String COLUMN_MIDINITIAL = "midinitial";
	public static final String COLUMN_USERNAME = "username";
	public static final String COLUMN_EMAIL = "email";
	public static final String COLUMN_STATUS = "status";
	public static final String COLUMN_LASTLOGIN = "lastlogin";
	public static final String COLUMN_LOGINATTEMPTS = "loginattempts";
	public static final String COLUMN_TYPE = "type";	
	
	private String accountid;
	private String lastname;
	private String firstname;
	private String midinitial;
	private String username;
	private String email;
	private String status;
	private String lastlogin;
	private String loginattempts;
	private String type;	
	private String account;
	private ArrayList<Transaction> transactions;
	private ArrayList<Card> cards;
	private ArrayList<Address> baddresses;
	
	public ArrayList<Address> getBaddresses() {
		return baddresses;
	}


	public void setBaddresses(ArrayList<Address> baddresses) {
		this.baddresses = baddresses;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}


	public ArrayList<Card> getCards() {
		return cards;
	}


	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMidinitial() {
		return midinitial;
	}
	public void setMidinitial(String midinitial) {
		this.midinitial = midinitial;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}
	public String getLoginattempts() {
		return loginattempts;
	}
	public void setLoginattempts(String loginattempts) {
		this.loginattempts = loginattempts;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
