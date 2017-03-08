package com.foobarbookshop.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foobarbookshop.beans.Product;
import com.foobarbookshop.services.ProductService;

/**
 * Servlet implementation class FindProduct
 */
@WebServlet("/DisplayAllProducts")
public class DisplayAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String filter;
		
		if (request.getParameter("type") != null)
			filter = request.getParameter("type");
		else
			filter = request.getParameter("search");
		
		int total = ProductService.totalProducts(filter);
		
		ArrayList<Product> products = ProductService.getAllProducts(filter);
		request.setAttribute("filter" , filter);
		request.setAttribute("products", products);
		request.setAttribute("total", total);

		// user w/o or w/ accnt can browse 
		if (session.getAttribute("user") == null || session.getAttribute("role").equals("customer")){
			if (request.getParameter("type") != null)
				request.getRequestDispatcher("shop-product-list.jsp").forward(request, response);
			else if (request.getParameter("search") != null){
				request.setAttribute("search", request.getParameter("search"));
				request.getRequestDispatcher("shop-search-result.jsp").forward(request, response);
			}			
		}
		else if (session.getAttribute("role").equals("admin") || session.getAttribute("role").equals("accntmgr") || session.getAttribute("role").equals("prdctmgr"))
			request.getRequestDispatcher("admin-product-list.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);	}

}
