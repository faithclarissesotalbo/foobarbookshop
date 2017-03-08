package com.foobarbookshop.beans;

import java.io.Serializable;

public class Billing implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "billing";
	public static final String COLUMN_ADDRESSID = "addressid";
	public static final String COLUMN_CARDID = "cardid";

	private String addressid;
	private String cardid;
	
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	
}
