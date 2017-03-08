package com.foobarbookshop.beans;

import java.io.Serializable;

public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "address";
	public static final String COLUMN_ADDRESSID = "addressID";
	public static final String COLUMN_HOMENUM = "homenum";	
	public static final String COLUMN_STREET = "street";
	public static final String COLUMN_SUBDIVISION = "subdivision";	
	public static final String COLUMN_CITY = "city";
	public static final String COLUMN_POSTALCODE = "postalcode";	
	public static final String COLUMN_COUNTRY = "country";
	public static final String COLUMN_TYPE = "type";	
	
	private String addressid;
	private String homenum;
	private String street;
	private String subdivision;
	private String city;
	private String postalcode;
	private String country;
	private String type;
	
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	public String getHomenum() {
		return homenum;
	}
	public void setHomenum(String homenum) {
		this.homenum = homenum;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSubdivision() {
		return subdivision;
	}
	public void setSubdivision(String subdivision) {
		this.subdivision = subdivision;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
