package com.foobarbookshop.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.foobarbookshop.beans.Account;
import com.foobarbookshop.beans.Item;
import com.foobarbookshop.beans.Product;
import com.foobarbookshop.beans.Review;
import com.foobarbookshop.beans.Transaction;
import com.foobarbookshop.db.DBManager;

public class ReviewService {
	// check if user can review 
	public boolean checkIfCanReview(String accountid, String productid){
		String sql= "SELECT * FROM " +  Item.TABLE_NAME + " i, " + Product.TABLE_NAME + " p, " + Transaction.TABLE_NAME + "  t, " + Account.TABLE_NAME + " a "
					+ "WHERE t." + Transaction.COLUMN_TRANSACTIONLIST + " = a." + Account.COLUMN_ACCOUNTID + " AND "
					+ "p." + Product.COLUMN_PRODUCTID + " = i." + Item.COLUMN_PRODUCTID + " AND "
					+ "a." + Account.COLUMN_ACCOUNTID + " = ? AND p." + Product.COLUMN_PRODUCTID + " = ? ";
		System.out.println(sql);
		
		boolean status = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountid);
			pstmt.setString(2, productid);
			
			rs = pstmt.executeQuery();
			
			//check mo kung tama ung nilagay ng user
			//if hindi throw ng error	
			status = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		return status;
	}
	
	// add a review
	public static void addReview(Review r){
		String sql = "INSERT INTO " + Review.TABLE_NAME + " ("
				+ Review.COLUMN_COMMENT + ", "
				+ Review.COLUMN_CUSTOMERID + ", "
				+ Review.COLUMN_PRODUCTID + ", "
				+ Review.COLUMN_RATING + ", "
				+ Review.COLUMN_TIMESTAMP
				+ ") VALUES (?, ?, ?, ?, NOW())";
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getComment());
			pstmt.setString(2, r.getCustomerID());
			pstmt.setString(3, r.getProductid());
			pstmt.setString(4, r.getRating());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}	
	
	// get all reviews in a specific product
	public static ArrayList<Review> getAllReviews(String productid){
		ArrayList<Review> reviewList = new ArrayList<Review>();
		
		String sql = "SELECT * FROM " + Review.TABLE_NAME + ", " + Account.TABLE_NAME
				+ " WHERE review." + Review.COLUMN_CUSTOMERID + " = account." + Account.COLUMN_ACCOUNTID + " AND "   
				+ Review.COLUMN_PRODUCTID + " = ? ORDER BY " + Review.COLUMN_TIMESTAMP + " DESC";
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productid);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				Review r = new Review();
				r.setReviewID(rs.getString(Review.COLUMN_REVIEWID));
				r.setComment(rs.getString(Review.COLUMN_COMMENT));
				r.setCustomerID(rs.getString(Account.COLUMN_USERNAME));
				r.setRating(rs.getString(Review.COLUMN_RATING));
				r.setTimestamp(rs.getString(Review.COLUMN_TIMESTAMP));

				reviewList.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		return reviewList;
	}
	
	// count all reviews in a specific product
	public static int totalReviews(String productid){
		int total = 0;
		
		String sql = "SELECT COUNT(*) FROM " + Review.TABLE_NAME
					+ " WHERE " + Review.COLUMN_PRODUCTID
					+ " = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productid);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				total = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		return total;
	}
	
	//delete review (temporary for now, but later on, make it just hidden)
	public static void deleteReview(String id){
		String sql = "DELETE FROM " + Review.TABLE_NAME
				+ " WHERE " + Review.COLUMN_REVIEWID + " = ?";
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
