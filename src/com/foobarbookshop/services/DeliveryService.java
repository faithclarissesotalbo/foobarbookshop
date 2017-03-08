package com.foobarbookshop.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.foobarbookshop.beans.Card;
import com.foobarbookshop.beans.Delivery;
import com.foobarbookshop.db.DBManager;

public class DeliveryService {
	//adds delivery address
	public void addDelivery(String addressid, String customerid){	
		String sql = "INSERT INTO " + Delivery.TABLE_NAME + " ("
				+ Delivery.COLUMN_ADDRESSID  + ", "
				+ Delivery.COLUMN_CUSTOMERID 
				+ ") VALUES (?, ?)";
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, addressid);
			pstmt.setString(2, customerid);

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
