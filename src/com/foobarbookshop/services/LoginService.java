package com.foobarbookshop.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.foobarbookshop.beans.Account;
import com.foobarbookshop.beans.Login;
import com.foobarbookshop.beans.Password;
import com.foobarbookshop.beans.Product;
import com.foobarbookshop.db.DBManager;

public class LoginService {

	// log in 
	public boolean checkLogin(String username, String password){
		String sql= "SELECT * FROM " + Account.TABLE_NAME + " a, " + Password.TABLE_NAME + " p "
					+ " WHERE p." + Password.COLUMN_ACCOUNTID + " = a." + Account.COLUMN_ACCOUNTID + " AND "
					+ "a." +  Account.COLUMN_USERNAME + " = ? AND p." + Password.COLUMN_HASHED + " = ?";
		
		System.out.println(sql);
		boolean status = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
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
	
	// count all products
	public static int totalDailyAttempts(String id){
		int total = 0;
		
		String sql = "SELECT COUNT(*) FROM " + Login.TABLE_NAME 
				+ " WHERE " + Login.COLUMN_ACCOUNTID + " = ? AND " + Login.COLUMN_TIMESTAMP + " > DATE_SUB(NOW(), INTERVAL 24 HOUR)"
				+ " ORDER BY " +  Login.COLUMN_TIMESTAMP  + " DESC " 
				+ " LIMIT 3";
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
				total = rs.getInt("COUNT(*)");
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
	
	//login attempt
	public static void addLoginAttempt(String id, String status){
		String sql = "INSERT " + Login.TABLE_NAME + " (" + Login.COLUMN_ACCOUNTID +  ", " + Login.COLUMN_STATUS + ") VALUES (?, ?)";
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, status);
			
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
	
	// gets list of logins 
	public static ArrayList<Login> get3LoginAttempts(String id){
		ArrayList<Login> loginList = new ArrayList<Login>();
		
		String sql = "SELECT * FROM " + Login.TABLE_NAME
					+ " WHERE " + Login.COLUMN_ACCOUNTID + " = ? AND " + Login.COLUMN_TIMESTAMP + " > DATE_SUB(NOW(), INTERVAL 24 HOUR)"
				+ " ORDER BY " +  Login.COLUMN_TIMESTAMP  + " DESC " 
				+ " LIMIT 3";
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
				Login l = new Login();
				l.setAccountid(rs.getString(Login.COLUMN_ACCOUNTID));
				l.setLoginid(rs.getString(Login.COLUMN_LOGINID));
				l.setStatus(rs.getString(Login.COLUMN_STATUS));
				l.setTimestamp(rs.getString(Login.COLUMN_TIMESTAMP));

				loginList.add(l);
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
		
		return loginList;
	}
	
	// timestamp diff
	public static int minAfterLastFail(String timestamp){
		int total = 0;
		
		String sql = "SELECT TIMESTAMPDIFF(minute, ?, NOW())";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println(sql);

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, timestamp);				
							
			rs = pstmt.executeQuery();
			while(rs.next()){
				total = rs.getInt("TIMESTAMPDIFF(minute, '" + timestamp + "', NOW())");
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
	
}
