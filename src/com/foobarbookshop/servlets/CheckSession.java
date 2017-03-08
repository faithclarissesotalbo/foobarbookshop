package com.foobarbookshop.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckSession
 */
@WebServlet("/CheckSession")
public class CheckSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String error = request.getParameter("type");
		
		if (session.getAttribute("user") == null)
			request.getRequestDispatcher("page-login.jsp").forward(request, response);
		else if (session.getAttribute("role").equals("admin") || 
				session.getAttribute("role").equals("accntmgr") || session.getAttribute("role").equals("prdctmgr"))
			request.getRequestDispatcher("admin-index.jsp").forward(request, response);
		else if (session.getAttribute("role").equals("customer")) {
			switch (error){
				case "main": request.getRequestDispatcher("shop-index.jsp").forward(request, response);
							 break;
				case "checkout": request.getRequestDispatcher("shop-checkout.jsp").forward(request, response);
							     break;
				//case "addtocart": break; 
			}
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
