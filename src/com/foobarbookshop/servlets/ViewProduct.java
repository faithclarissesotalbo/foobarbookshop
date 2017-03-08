package com.foobarbookshop.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foobarbookshop.beans.Account;
import com.foobarbookshop.beans.Product;
import com.foobarbookshop.services.ProductService;
import com.foobarbookshop.services.ReviewService;

/**
 * Servlet implementation class VIewProduct
 */
@WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		Account a = (Account) session.getAttribute("member");
		Product p = new Product();
		ProductService productServe = new ProductService();
		ReviewService reviewServe = new ReviewService();
		
		p = productServe.getProduct(request.getParameter("title"));
		
		request.setAttribute("p", p);
		
		if (session.getAttribute("user") == null || a.getType().equals("customer")){
			boolean status = false;
			
			if (session.getAttribute("user") != null)
				status = reviewServe.checkIfCanReview(a.getAccountid(), p.getProductid());
			
			// test if can review
			request.setAttribute("status", status);
			request.setAttribute("totalreviews", reviewServe.totalReviews(p.getProductid()));
			request.setAttribute("reviews", reviewServe.getAllReviews(p.getProductid()));
			
			request.getRequestDispatcher("shop-item.jsp").forward(request,response);
		} else {	
			request.setAttribute("totalreviews", reviewServe.totalReviews(p.getProductid()));
			request.setAttribute("reviews", reviewServe.getAllReviews(p.getProductid()));
			
			request.setAttribute("role", a.getType());
			request.getRequestDispatcher("admin-product-content.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
