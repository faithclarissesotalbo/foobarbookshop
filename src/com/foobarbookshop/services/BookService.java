package com.foobarbookshop.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foobarbookshop.beans.Book;
import com.foobarbookshop.beans.Product;
import com.foobarbookshop.db.DBManager;

public class BookService {
	// add book
	public static void addBook(String id, String author){
		String sql = "INSERT INTO " + Book.TABLE_NAME + " ("
				+ Book.COLUMN_PRODUCTID + ", "
				+ Book.COLUMN_AUTHOR +  ") VALUES (" + id + ", "  + " ?)";
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, author);

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
	
	//get book details
	public static Book getBook(String id){
		Book book = new Book();
		
		String sql = "SELECT * FROM " + Product.TABLE_NAME
				+ " WHERE " + Product.COLUMN_PRODUCTID
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
				String bookid = rs.getString(Product.COLUMN_PRODUCTID);
				book.setProductid(bookid);
				
				String author = rs.getString(Book.COLUMN_AUTHOR);
				book.setAuthor(author);;

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
		
		return book;
	}
}
