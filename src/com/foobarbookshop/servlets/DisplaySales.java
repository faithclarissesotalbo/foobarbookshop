package com.foobarbookshop.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foobarbookshop.beans.Product;
import com.foobarbookshop.services.ProductService;

/**
 * Servlet implementation class DisplaySales
 */
@WebServlet("/DisplaySales")
public class DisplaySales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplaySales() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productServe = new ProductService();
		ArrayList<Product> productlist = productServe.salesPerProduct();
		ArrayList<Product> salespertypelist = productServe.totalSalesPerType();
		
		request.setAttribute("producttype", salespertypelist);
		request.setAttribute("totalsales", productServe.totalSales());
		request.setAttribute("salesperproduct", productlist);
		request.getRequestDispatcher("admin-sales.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
