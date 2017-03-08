package com.foobarbookshop.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foobarbookshop.beans.Account;
import com.foobarbookshop.beans.Card;
import com.foobarbookshop.beans.Product;
import com.foobarbookshop.db.DBManager;

public class CardService {	
	//adds credit card
	public void addCard(Card c){	
		String sql = "INSERT INTO " + Card.TABLE_NAME + " ("
				+ Card.COLUMN_ACCOUNTID + ", "
				+ Card.COLUMN_NAME + ", "
				+ Card.COLUMN_CARDNUM + ", "
				+ Card.COLUMN_TYPE + ", "
				+ Card.COLUMN_EXPIREDATE
				+ ") VALUES (?, ?, ?, ?, ?)";
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getAccountid());
			pstmt.setString(2, c.getName());
			pstmt.setString(3, c.getCardnum());
			pstmt.setString(4, c.getType());			
			pstmt.setString(5, c.getExpiredate());
			
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
	
	//gets credit card detail
	public static Card getCard(String id){
		Card card = new Card();
		
		String sql = "SELECT * FROM " + Card.TABLE_NAME
				+ " WHERE " + Card.COLUMN_ACCOUNTID
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
				String cardid = rs.getString(Card.COLUMN_CARDID);
				card.setCardid(cardid);
				
				String cardnum = rs.getString(Card.COLUMN_CARDNUM);
				card.setCardnum(cardnum);
				
				String expiredate = rs.getString(Card.COLUMN_EXPIREDATE);
				card.setExpiredate(expiredate);
				
				String name = rs.getString(Card.COLUMN_NAME);
				card.setName(name);
				
				String type = rs.getString(Card.COLUMN_TYPE);
				card.setType(type);
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
		
		return card;
	}
}
