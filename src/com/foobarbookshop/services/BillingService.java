package com.foobarbookshop.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foobarbookshop.beans.Account;
import com.foobarbookshop.beans.Address;
import com.foobarbookshop.beans.Billing;
import com.foobarbookshop.beans.Card;
import com.foobarbookshop.db.DBManager;

public class BillingService {

	//adds billingAddress
	public void addAddress(String addressid, String cardid){	
		String sql = "INSERT INTO " + Billing.TABLE_NAME + " ("
				+ Billing.COLUMN_ADDRESSID + ", "
				+ Billing.COLUMN_CARDID
				+ ") VALUES (?, ?)";
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, addressid);
			pstmt.setString(2, cardid);

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
	
	//adds billingAddress
	public static Billing getBilling(String id){
		Billing billing = new Billing();
		
		String sql = "SELECT * FROM " + Billing.TABLE_NAME
				+ " WHERE " + Billing.COLUMN_CARDID
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
				String addressid = rs.getString(Billing.COLUMN_ADDRESSID);
				billing.setAddressid(addressid);
				
				String cardid = rs.getString(Billing.COLUMN_CARDID);
				billing.setCardid(cardid);
				
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
		
		return billing;
	}
}
