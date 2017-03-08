package com.foobarbookshop.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.foobarbookshop.beans.Item;
import com.foobarbookshop.beans.Product;
import com.foobarbookshop.db.DBManager;

public class ItemService {
	// add item into transaction
	public static void addItem(String transactionid, Product p){
		String sql = "INSERT INTO " + Item.TABLE_NAME + " ("
				+ Item.COLUMN_TRANSACTIONID + ", "
				+ Item.COLUMN_PRODUCTID + ", "
				+ Item.COLUMN_QUANTITY
				+ ") VALUES (?, ?, ?)";
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, transactionid);
			pstmt.setString(2, p.getProductid());
			pstmt.setInt(3, p.getQty());

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
