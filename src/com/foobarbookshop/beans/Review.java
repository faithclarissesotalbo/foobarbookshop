package com.foobarbookshop.beans;

import java.io.Serializable;

public class Review implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "review";
	public static final String COLUMN_REVIEWID = "reviewID";
	public static final String COLUMN_PRODUCTID = "productid";
	public static final String COLUMN_CUSTOMERID = "customerID";
	public static final String COLUMN_RATING = "rating";
	public static final String COLUMN_COMMENT = "comment";
	public static final String COLUMN_TIMESTAMP = "timestamp";

	private String reviewID;
	private String productid;
	private String comment;
	private String customerID;
	private String rating;
	private String timestamp;
	
	
	public String getReviewID() {
		return reviewID;
	}
	public void setReviewID(String reviewID) {
		this.reviewID = reviewID;
	}
	
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
