package com.foobarbookshop.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;


public class DBManager {
	public static Connection getConnection() throws SQLException{
		BasicDataSource bds = new BasicDataSource();
		
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/foobar?useSSL=false");
		bds.setUsername("root");
		bds.setPassword("toor");	
		
		return bds.getConnection();
	}
}
