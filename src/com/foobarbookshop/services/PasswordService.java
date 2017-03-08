package com.foobarbookshop.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.foobarbookshop.beans.Password;
import com.foobarbookshop.db.DBManager;

public class PasswordService {
	// create password
	public static void createPassword(String id, Password p){
		String sql = "INSERT " + Password.TABLE_NAME + "(" + Password.COLUMN_ACCOUNTID + ", " + Password.COLUMN_HASHED + ", " + Password.COLUMN_ENCRYPTED + ")"
				+ " VALUES (?, ?, ?)";
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, p.getHashedpw());
			pstmt.setString(3, p.getEncryptedpw());
			
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
