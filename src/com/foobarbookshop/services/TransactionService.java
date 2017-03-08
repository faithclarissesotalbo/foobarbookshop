package com.foobarbookshop.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.foobarbookshop.beans.Account;
import com.foobarbookshop.beans.Item;
import com.foobarbookshop.beans.Product;
import com.foobarbookshop.beans.Transaction;
import com.foobarbookshop.db.DBManager;

public class TransactionService {
	// addt to transaction
	public static void addTransaction(String id){
		String sql = "INSERT INTO " + Transaction.TABLE_NAME + " ("
				+ Transaction.COLUMN_TIMESTAMP + ", "
				+ Transaction.COLUMN_TRANSACTIONLIST	
				+ ") VALUES (CURDATE(), ?)";
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
	
	// add get transaction details
	// get product detail
	public static Transaction getTransaction(String id){
		Transaction transact = new Transaction();
		
		String sql = "SELECT * FROM " + Transaction.TABLE_NAME
				+ " WHERE " + Transaction.COLUMN_TRANSACTIONLIST
				+ " = ?";
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String timestamp = rs.getString(Transaction.COLUMN_TIMESTAMP);
				transact.setTimestamp(timestamp);
				
				String transactionID = rs.getString(Transaction.COLUMN_TRANSACTIONID);
				transact.setTransactionID(transactionID);
				
				String transactionlist = rs.getString(Transaction.COLUMN_TRANSACTIONLIST);
				transact.setTransactionlist(transactionlist);
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
		
		return transact;
	}
	
	// gets the purchasing history
	public static ArrayList<Item> getPurchasingHistory(String id){
		ArrayList<Item> items = new ArrayList<>();
		
		String sql = "SELECT i." + Item.COLUMN_TRANSACTIONID + ", i." + Item.COLUMN_QUANTITY + ", i." + Item.COLUMN_PRODUCTID 
					+ " FROM " + Item.TABLE_NAME + " i, " + Product.TABLE_NAME + " p, " + Transaction.TABLE_NAME + " t, " + Account.TABLE_NAME + " a "
					+ " WHERE t." + Transaction.COLUMN_TRANSACTIONLIST + " = a." + Account.COLUMN_ACCOUNTID + " AND "
					+ "p." + Product.COLUMN_PRODUCTID + " = i." + Item.COLUMN_PRODUCTID + " AND "
					+ " a." + Account.COLUMN_ACCOUNTID + " = ?"
					+ "GROUP BY i." + Item.COLUMN_TRANSACTIONID; 
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Item i = new Item();
				
				i.setProductid(rs.getString(Item.COLUMN_PRODUCTID));
				i.setQuantity(rs.getString(Item.COLUMN_QUANTITY));
				i.setTransactionid(rs.getString(Item.COLUMN_TRANSACTIONID));

				items.add(i);
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
		
		return items;
	}
}
