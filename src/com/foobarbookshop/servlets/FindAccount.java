package com.foobarbookshop.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foobarbookshop.beans.Account;
import com.foobarbookshop.services.AccountService;

/**
 * Servlet implementation class FindUser
 */
@WebServlet("/FindAccount")
public class FindAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("user") == null || !session.getAttribute("role").equals("admin") || 
				!session.getAttribute("role").equals("accntmgr") || !session.getAttribute("role").equals("prdctmgr"))
			request.getRequestDispatcher("page-login.jsp").forward(request, response);
		
		Account a = new Account();
			
		AccountService accountServe = new AccountService();
		a = accountServe.getDetails(request.getParameter("username"));
		
		request.setAttribute("u", a);
		request.getRequestDispatcher("admin-users.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
