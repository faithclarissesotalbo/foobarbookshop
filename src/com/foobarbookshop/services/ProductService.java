package com.foobarbookshop.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.foobarbookshop.beans.Account;
import com.foobarbookshop.beans.Address;
import com.foobarbookshop.beans.Item;
import com.foobarbookshop.beans.Product;
import com.foobarbookshop.db.DBManager;

public class ProductService {
	// get product detail
	public static Product getProduct(String id){
		Product product = new Product();
		
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
				product.setProductid(bookid);
				
				String acquiredate = rs.getString(Product.COLUMN_ACQUIREDATE);
				product.setAcquiredate(acquiredate);
				
				String description = rs.getString(Product.COLUMN_DESCRIPTION);
				product.setDescription(description);
				
				String genre = rs.getString(Product.COLUMN_GENRE);
				product.setGenre(genre);
				
				String price = rs.getString(Product.COLUMN_PRICE);
				product.setPrice(price);
				
				String stock = rs.getString(Product.COLUMN_STOCK);
				product.setStock(stock);
				
				String title = rs.getString(Product.COLUMN_TITLE);
				product.setTitle(title);
				
				String type = rs.getString(Product.COLUMN_TYPE);
				product.setType(type);

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
		
		return product;
	}
	
	// count all products
	public static int totalProducts(String filter){
		int total = 0;
		String column = ""; 
		
		// if filter sya o hindi
		if (filter.equals("book") || filter.equals("audiocd") || filter.equals("dvd") || filter.equals("magazine"))
			column = Product.COLUMN_TYPE + " = ?";
		else
			column = Product.COLUMN_TITLE  + " LIKE ?";		
		
		String sql = "SELECT COUNT(*) FROM " + Product.TABLE_NAME
					+ " WHERE " + column;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (filter.equals("book") || filter.equals("audiocd") || filter.equals("dvd") || filter.equals("magazine"))
				pstmt.setString(1, filter);
			else
				pstmt.setString(1, "%" +  filter +  "%");				
							
			rs = pstmt.executeQuery();
			while(rs.next()){
				total = rs.getInt("count(*)");
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
	
	// find product using filter
	public static ArrayList<Product> getAllProducts(String filter){
		ArrayList<Product> productList = new ArrayList<Product>();
		String column = ""; 
		
		// if filter sya o hindi
		if (filter.equals("book") || filter.equals("audiocd") || filter.equals("dvd") || filter.equals("magazine"))
			column = Product.COLUMN_TYPE + " = ?";
		else
			column = Product.COLUMN_TITLE  + " LIKE ?";
		
		String sql = "SELECT * FROM " + Product.TABLE_NAME
					+ " WHERE " + column;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println(sql);

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (filter.equals("book") || filter.equals("audiocd") || filter.equals("dvd") || filter.equals("magazine"))
				pstmt.setString(1, filter);
			else
				pstmt.setString(1, "%" +  filter +  "%");	
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product p = new Product();
				p.setProductid(rs.getString(Product.COLUMN_PRODUCTID));
				p.setAcquiredate(rs.getString(Product.COLUMN_ACQUIREDATE));
				p.setDescription(rs.getString(Product.COLUMN_DESCRIPTION));
				p.setGenre(rs.getString(Product.COLUMN_GENRE));
				p.setPrice(rs.getString(Product.COLUMN_PRICE));
				p.setStock(rs.getString(Product.COLUMN_STOCK));
				p.setTitle(rs.getString(Product.COLUMN_TITLE));
				p.setType(rs.getString(Product.COLUMN_TYPE));
				
				productList.add(p);
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
		
		return productList;
	}
	
	// add product
	public static String addProduct(Product p){
		String sql = "INSERT INTO " + Product.TABLE_NAME + " ("
				+ Product.COLUMN_TITLE + ", "
				+ Product.COLUMN_DESCRIPTION + ", "
				+ Product.COLUMN_PRICE + ", "				
				+ Product.COLUMN_GENRE + ", "
				+ Product.COLUMN_TYPE + ", "
				+ Product.COLUMN_STOCK + ", "
				+ Product.COLUMN_ACQUIREDATE
				+ ") VALUES (?, ?, ?, ?, ?, ?, ?)";
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getTitle());
			pstmt.setString(2, p.getDescription());
			pstmt.setString(3, p.getPrice());
			pstmt.setString(4, p.getGenre());			
			pstmt.setString(5, p.getType());
			pstmt.setString(6, p.getStock());
			pstmt.setString(7, p.getAcquiredate());

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
		
		sql = "SELECT " + Product.COLUMN_PRODUCTID + " FROM " + Product.TABLE_NAME 
				+ " WHERE " + Product.COLUMN_ACQUIREDATE + " = ? AND "
				+  Product.COLUMN_DESCRIPTION + " = ? AND "
				+  Product.COLUMN_GENRE + " = ? AND "
				+  Product.COLUMN_PRICE + " = ? AND "
				+  Product.COLUMN_STOCK + " = ? AND "
				+  Product.COLUMN_TITLE + " = ?";
		String productid = null;
		ResultSet rs = null;
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, p.getAcquiredate());
			pstmt.setString(2, p.getDescription());
			pstmt.setString(3, p.getGenre());
			pstmt.setString(4, p.getPrice());
			pstmt.setString(5, p.getStock());
			pstmt.setString(6, p.getTitle());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				productid = rs.getString(Product.COLUMN_PRODUCTID);
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
		return productid;
	}
	
	// edit product
	public Product editProduct(Product p){
		String sql = "UPDATE " + Product.TABLE_NAME + " SET "
				+ Product.COLUMN_ACQUIREDATE + " = ?, "
				+ Product.COLUMN_DESCRIPTION + " = ?, "
				+ Product.COLUMN_GENRE + " = ?, "
				+ Product.COLUMN_PRICE + " = ? , "
				+ Product.COLUMN_STOCK + " = ?, "
				+ Product.COLUMN_TITLE + " = ?, "
				+ Product.COLUMN_TYPE + " = ? "
				+ " WHERE " + Product.COLUMN_PRODUCTID + " = ?";
		System.out.println(sql);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getAcquiredate());
			pstmt.setString(2, p.getDescription());
			pstmt.setString(3, p.getGenre());
			pstmt.setString(4, p.getPrice());
			pstmt.setString(5, p.getStock());
			pstmt.setString(6, p.getTitle());
			pstmt.setString(7, p.getType());
			pstmt.setString(8, p.getProductid());

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

		return p;
	}	
	
	//delete product (temporary for now, but later on, make it just hidden)
	public static void deleteProduct(String id){
		String sql = "DELETE FROM " + Product.TABLE_NAME
				+ " WHERE " + Product.COLUMN_PRODUCTID + " = ?";
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(sql);
		
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
	}
	
	
	// for account manager (list of sales per product)
	public static ArrayList<Product> salesPerProduct(){
		ArrayList<Product> salesperproduct = new ArrayList<>();
		
		String sql = "SELECT " + Product.COLUMN_TITLE + ", " + Product.COLUMN_PRICE + ", SUM(" + Item.COLUMN_QUANTITY + " * " + Product.COLUMN_PRICE 
					+ ") FROM " +  Item.TABLE_NAME + ", " + Product.TABLE_NAME
					+ " WHERE " + Item.TABLE_NAME + "." + Item.COLUMN_PRODUCTID + " = " + Product.TABLE_NAME + "." +  Product.COLUMN_PRODUCTID
					+ " GROUP BY " + Item.TABLE_NAME + "." + Item.COLUMN_PRODUCTID
					+ " ORDER BY SUM(" + Item.COLUMN_QUANTITY + " * " + Product.COLUMN_PRICE + ") DESC";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
							
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product p = new Product();
				
				p.setPrice(rs.getString("SUM(" + Item.COLUMN_QUANTITY + " * " + Product.COLUMN_PRICE + ")"));
				p.setTitle(rs.getString(Product.COLUMN_TITLE));
				p.setQty(rs.getInt(Product.COLUMN_PRICE));
				
				salesperproduct.add(p);
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
		
		return salesperproduct;
	}
	
	// for account manager (total sales)
	public static int totalSales(){
		int total = 0;
		
		String sql = "SELECT SUM(" + Item.COLUMN_QUANTITY + " * " + Product.COLUMN_PRICE +") FROM "
				+ Item.TABLE_NAME + ", " + Product.TABLE_NAME
				+ " WHERE " + Item.TABLE_NAME + "." + Item.COLUMN_PRODUCTID + " = " + Product.TABLE_NAME + "." + Product.COLUMN_PRODUCTID;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				total = rs.getInt("SUM(" + Item.COLUMN_QUANTITY + " * " + Product.COLUMN_PRICE +")");
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
	
	// for account manager (list of sales per type)
	public static ArrayList<Product> totalSalesPerType(){
		ArrayList<Product> salespertype = new ArrayList<>();
		
		String sql = "SELECT " + Product.COLUMN_TYPE + ", SUM(" + Item.COLUMN_QUANTITY + " * " + Product.COLUMN_PRICE +") FROM "
				+ Item.TABLE_NAME + ", " + Product.TABLE_NAME 
				+ " WHERE " + Item.TABLE_NAME + "." + Item.COLUMN_PRODUCTID + " = " + Product.TABLE_NAME + "." + Product.COLUMN_PRODUCTID
				+ " GROUP BY " + Product.COLUMN_TYPE;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
							
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product p = new Product();
				
				p.setPrice(rs.getString("SUM(" + Item.COLUMN_QUANTITY + " * " + Product.COLUMN_PRICE + ")"));
				p.setType(rs.getString(Product.COLUMN_TYPE));
				
				salespertype.add(p);
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
		
		return salespertype;
	}
	
}
