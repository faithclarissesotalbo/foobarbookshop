package com.foobarbookshop.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foobarbookshop.beans.Account;
import com.foobarbookshop.beans.Review;
import com.foobarbookshop.services.ReviewService;

/**
 * Servlet implementation class AddReview
 */
@WebServlet("/AddReview")
public class AddReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		Account a = (Account) session.getAttribute("member");
		Review review = new Review();
		ReviewService reviewServe = new ReviewService();
		
		review.setComment(request.getParameter("comment"));
		review.setCustomerID(a.getAccountid());
		review.setProductid(request.getParameter("productid"));
		review.setRating(request.getParameter("rating"));
		
		reviewServe.addReview(review);
		request.getRequestDispatcher("ViewProduct?title=" + request.getParameter("productid")).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
