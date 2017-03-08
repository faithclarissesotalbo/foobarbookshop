package com.foobarbookshop.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foobarbookshop.beans.Account;
import com.foobarbookshop.beans.Address;
import com.foobarbookshop.db.DBManager;

public class AddressService {
	
	//adds address
	public static String addAddress(Address a){	
		String addressid = null; 
		
		String sql = "INSERT INTO " + Address.TABLE_NAME + " ("
				+ Address.COLUMN_HOMENUM + ", "
				+ Address.COLUMN_STREET + ", "
				+ Address.COLUMN_SUBDIVISION + ", "
				+ Address.COLUMN_CITY + ", "
				+ Address.COLUMN_POSTALCODE + ", "
				+ Address.COLUMN_COUNTRY
				+ ") VALUES (?, ?, ?, ?, ?, ?)";
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, a.getHomenum());
			pstmt.setString(2, a.getStreet());
			pstmt.setString(3, a.getSubdivision());
			pstmt.setString(4, a.getCity());			
			pstmt.setString(5, a.getPostalcode());
			pstmt.setString(6, a.getCountry());

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
		
		sql = "SELECT " + Address.COLUMN_ADDRESSID + " FROM " + Address.TABLE_NAME 
				+ " WHERE " + Address.COLUMN_CITY + " = ? AND "
				+  Address.COLUMN_COUNTRY + " = ? AND "
				+  Address.COLUMN_HOMENUM + " = ? AND "
				+  Address.COLUMN_POSTALCODE + " = ? AND "
				+  Address.COLUMN_STREET + " = ? AND "
				+  Address.COLUMN_SUBDIVISION + " = ?";		
		ResultSet rs = null;
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, a.getCity());
			pstmt.setString(2, a.getCountry());
			pstmt.setString(3, a.getHomenum());
			pstmt.setString(4, a.getPostalcode());
			pstmt.setString(5, a.getStreet());
			pstmt.setString(6, a.getSubdivision());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				addressid = rs.getString(Address.COLUMN_ADDRESSID);
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
		
		return addressid;
		
	}
	
	
}
