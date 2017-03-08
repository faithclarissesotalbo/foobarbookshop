package com.foobarbookshop.beans;

import java.io.Serializable;

public class AudioCD extends Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "audiocd";
	public static final String COLUMN_PRODUCTID = "productid";
	public static final String COLUMN_ARTIST = "artist";

	private String productid;
	private String artist;
	
	public AudioCD(){
		super();
	}
	
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	


}
