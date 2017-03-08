package com.foobarbookshop.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foobarbookshop.beans.Account;
import com.foobarbookshop.beans.Question;
import com.foobarbookshop.db.DBManager;

public class QuestionService {
	
	// add question
	public void addQuestion(Question q){
		String sql = "INSERT " + Question.TABLE_NAME + "("  + Question.COLUMN_QUESTION + ", " + Question.COLUMN_ANSWER + ", " + Question.COLUMN_ACCOUNTID + ") "
				+ " VALUES (?, ? ,?)";
		
		boolean status = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, q.getQuestion());	
			pstmt.setString(2, q.getAnswer());	
			pstmt.setString(3, q.getAccountid());	

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
	
	// display question
	public Question displayQuestion(String id){
		Question q = new Question();
		String sql = "SELECT * FROM " + Question.TABLE_NAME + " WHERE " + Question.COLUMN_ACCOUNTID + "= ?";
		
		boolean status = false;
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
				q.setQuestionid(Question.COLUMN_QUESTIONID);
				q.setAccountid(rs.getString(Question.COLUMN_ACCOUNTID));
				q.setQuestion(rs.getString(Question.COLUMN_QUESTION));
				q.setAnswer(rs.getString(Question.COLUMN_ANSWER));
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
		
		return q;
	}
	
	public boolean checkAnswer(Question q){
		String sql = "SELECT * FROM " + Question.TABLE_NAME + " WHERE "
				+ Question.COLUMN_ACCOUNTID + " = ? AND " + Question.COLUMN_QUESTION + " = ? AND " + Question.COLUMN_ANSWER + " = ?";
		
		boolean status = false;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, q.getAccountid());	
			pstmt.setString(2, q.getQuestion());
			pstmt.setString(3, q.getAnswer());
			
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
}
