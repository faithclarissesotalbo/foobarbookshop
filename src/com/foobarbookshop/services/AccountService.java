package com.foobarbookshop.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.foobarbookshop.beans.Account;
import com.foobarbookshop.beans.Address;
import com.foobarbookshop.beans.Billing;
import com.foobarbookshop.beans.Card;
import com.foobarbookshop.db.DBManager;

public class AccountService {

	//FOR REGISTRATION
	// search kung unique yung username na napili
	public boolean checkUnique(String u){
		String sql = "SELECT * FROM " + Account.TABLE_NAME + " WHERE "
				+ Account.COLUMN_USERNAME + " = ?";
		
		boolean status = false;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u);	
			
			rs = pstmt.executeQuery();
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
	
	// create account and get the account id
	public static String createAccount(Account u){
		String sql = "INSERT INTO " + Account.TABLE_NAME + " ("
				+ Account.COLUMN_LASTNAME + ", "
				+ Account.COLUMN_FIRSTNAME + ", "
				+ Account.COLUMN_MIDINITIAL + ", "
				+ Account.COLUMN_USERNAME + ", "
				+ Account.COLUMN_EMAIL
				+ ") VALUES (?, ?, ?, ?, ?)";
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getLastname());
			pstmt.setString(2, u.getFirstname());
			pstmt.setString(3, u.getMidinitial());
			pstmt.setString(4, u.getUsername());			
			pstmt.setString(5, u.getEmail());
			
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
		
		sql = "SELECT " + Account.COLUMN_ACCOUNTID + " FROM " + Account.TABLE_NAME 
				+ " WHERE " + Account.COLUMN_USERNAME + " = ?";
		ResultSet rs = null;
		String accountid = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, u.getUsername());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				accountid = rs.getString(Account.COLUMN_ACCOUNTID);
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
		
		
		return accountid;
	}
		
	// VIEW PROFILE
	// kukunin mo na mismo yung details ng user once na nakalog in na sya
	public Account getDetails(String u){
		String sql = "SELECT * FROM " + Account.TABLE_NAME
				+ " WHERE " + Account.COLUMN_USERNAME + "= ?"; 
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account account = new Account();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u);
			
			rs = pstmt.executeQuery();
						
			while(rs.next()){
				String accountid = rs.getString(Account.COLUMN_ACCOUNTID);
				account.setAccountid(accountid);
				
				String username = rs.getString(Account.COLUMN_USERNAME);
				account.setUsername(username);
				
				String firstname = rs.getString(Account.COLUMN_FIRSTNAME);
				account.setFirstname(firstname);
				
				String lastname = rs.getString(Account.COLUMN_LASTNAME);
				account.setLastname(lastname);
				
				String midinitial = rs.getString(Account.COLUMN_MIDINITIAL);
				account.setMidinitial(midinitial);
				
				String email = rs.getString(Account.COLUMN_EMAIL);
				account.setEmail(email);
				
				String role = rs.getString(Account.COLUMN_TYPE);
				account.setType(role);
				
				String status = rs.getString(Account.COLUMN_STATUS);
				account.setStatus(status);
				
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
		
		// getting credit card and billing address
		sql = "SELECT * FROM " +  Address.TABLE_NAME + " ad, " + Account.TABLE_NAME + " a, " + Card.TABLE_NAME + " c, " + Billing.TABLE_NAME + " b "
				+ "WHERE b." + Billing.COLUMN_CARDID + " = c." + Card.COLUMN_CARDID + " AND "
				+ "a." + Account.COLUMN_ACCOUNTID + " = c." + Card.COLUMN_ACCOUNTID + " AND "
				+ "ad." + Address.COLUMN_ADDRESSID + " = b." + Billing.COLUMN_ADDRESSID + " AND "
				+ "a." + Account.COLUMN_ACCOUNTID + "= ? ";
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getAccountid());
			System.out.println(account.getAccountid());
			rs = pstmt.executeQuery();
						
			// for now, 1:1 sila
			while(rs.next()){
				Address ad = new Address();
				ArrayList<Address> baddresses = new ArrayList<Address>();
				
				ad.setAddressid(rs.getString("ad." + Address.COLUMN_ADDRESSID));
				ad.setCity(rs.getString("ad." + Address.COLUMN_CITY));
				ad.setCountry(rs.getString("ad." + Address.COLUMN_COUNTRY));
				ad.setHomenum(rs.getString("ad." + Address.COLUMN_HOMENUM));
				ad.setPostalcode(rs.getString("ad." + Address.COLUMN_HOMENUM));
				ad.setStreet(rs.getString("ad." + Address.COLUMN_STREET));
				ad.setSubdivision(rs.getString("ad." + Address.COLUMN_SUBDIVISION));
				baddresses.add(ad);
				account.setBaddresses(baddresses);
				
				Card c = new Card();
				ArrayList<Card> cards = new ArrayList<Card>();
				
				c.setCardid(rs.getString("c." + Card.COLUMN_CARDID));
				c.setCardnum(rs.getString("c." + Card.COLUMN_CARDNUM));
				c.setExpiredate(rs.getString("c." + Card.COLUMN_EXPIREDATE));
				c.setName(rs.getString("c." + Card.COLUMN_NAME));
				c.setType(rs.getString("c." + Card.COLUMN_TYPE));
				cards.add(c);
				account.setCards(cards);
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
								
				
				
		return account;	
		
	}	
	
	// change status to lock
	public void changeStatustoLocked(String user){
		String sql = "UPDATE " + Account.TABLE_NAME + " SET "
				+ Account.COLUMN_STATUS + "= 'locked'"
				+ " WHERE " + Account.COLUMN_ACCOUNTID + " = ?";
		System.out.println(sql);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);

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
	
	// change status to unlock
	public void changeStatustoUnLocked(String user){
		String sql = "UPDATE " + Account.TABLE_NAME + " SET "
				+ Account.COLUMN_STATUS + "= 'unlocked'"
				+ " WHERE " + Account.COLUMN_ACCOUNTID + " = ?";
		System.out.println(sql);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);

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
	
	// update profile (both admin/user page)
	public Account editProfile(Account a){
		//User user = new User();
		String sql = "UPDATE " + Account.TABLE_NAME + " SET "
				+ Account.COLUMN_LASTNAME + "= ?" + ", "
				+ Account.COLUMN_FIRSTNAME + "= ?" + ", "
				+ Account.COLUMN_MIDINITIAL + "= ?" + ", "
				+ Account.COLUMN_USERNAME  + "= ?" + ", "
				+ Account.COLUMN_EMAIL + "= ?" + ", "
				+ Account.COLUMN_TYPE + "= ?"
				+ " WHERE " + Account.COLUMN_ACCOUNTID + " = ?" ;
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getLastname());
			pstmt.setString(2, a.getFirstname());
			pstmt.setString(3, a.getMidinitial());
			pstmt.setString(4, a.getUsername());//*/
			pstmt.setString(5, a.getEmail());
			pstmt.setString(6, a.getType());
			pstmt.setString(7, a.getAccountid());

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
		
		return a;
	}

	// updateprofile for customer
	// update profile (both admin/user page)
	public Account editProfileCust(Account a){
		//User user = new User();
		String sql = "UPDATE " +  Address.TABLE_NAME + " ad, " + Account.TABLE_NAME + " a, " + Card.TABLE_NAME + " c, " + Billing.TABLE_NAME + " b "
				+ "SET a." + Account.COLUMN_LASTNAME + "= ?" + ", a."
				+ Account.COLUMN_FIRSTNAME + "= ?" + ", a."
				+ Account.COLUMN_MIDINITIAL + "= ?" + ", a."
				+ Account.COLUMN_USERNAME  + "= ?" + ", a."
				+ Account.COLUMN_EMAIL + "= ? " + ", ad."
				+ Address.COLUMN_CITY + "= ?" + ", ad."
				+ Address.COLUMN_COUNTRY + "= ?" + ", ad." 
				+ Address.COLUMN_HOMENUM + "= ?" + ", ad." 
				+ Address.COLUMN_POSTALCODE + "= ?" + ", ad."
				+ Address.COLUMN_STREET + "= ?" + ", ad."
				+ Address.COLUMN_SUBDIVISION + "= ?" + ", c."
				+ Card.COLUMN_CARDNUM + "= ?" + ", c." 
				+ Card.COLUMN_EXPIREDATE + "= ?" + ", c."
				+ Card.COLUMN_NAME + "= ?" + " "//*/
				+ "WHERE b." + Billing.COLUMN_CARDID + " = c." + Card.COLUMN_CARDID + " AND "
				+ "a." + Account.COLUMN_ACCOUNTID + " = c." + Card.COLUMN_ACCOUNTID + " AND "
				+ "ad." + Address.COLUMN_ADDRESSID + " = b." + Billing.COLUMN_ADDRESSID + " AND "
				+ "a." + Account.COLUMN_ACCOUNTID + "= ? ";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, a.getLastname());
			pstmt.setString(2, a.getFirstname());
			pstmt.setString(3, a.getMidinitial());
			pstmt.setString(4, a.getUsername());
			pstmt.setString(5, a.getEmail());
			pstmt.setString(6, a.getBaddresses().get(0).getCity());
			pstmt.setString(7, a.getBaddresses().get(0).getCountry());
			pstmt.setString(8, a.getBaddresses().get(0).getHomenum());
			pstmt.setString(9, a.getBaddresses().get(0).getPostalcode());
			pstmt.setString(10, a.getBaddresses().get(0).getStreet());
			pstmt.setString(11, a.getBaddresses().get(0).getSubdivision());
			pstmt.setString(12, a.getCards().get(0).getCardnum());
			pstmt.setString(13, a.getCards().get(0).getExpiredate());
			pstmt.setString(14, a.getCards().get(0).getName());
			pstmt.setString(15, a.getAccountid());

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
		
		return a;
	}	
	
	// log out
/*	public void logOut(String id){
		String sql = "UPDATE " + Account.TABLE_NAME + " SET "
				+ Account.COLUMN_LASTLOGIN + "= NOW()"
				+ " WHERE " + Account.COLUMN_ACCOUNTID + " = ?";
		System.out.println(sql + id);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
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
		
	}*/	
	
}
