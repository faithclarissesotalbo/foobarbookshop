package com.foobarbookshop.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foobarbookshop.beans.Account;

/**
 * Servlet implementation class ChangeStatusAccount
 */
@WebServlet("/ChangeStatusAccount")
public class ChangeStatusAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStatusAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account a = new Account();
		AccountService accountServe = new AccountService();
		
		if (request.getParameter("hstatus").equals("locked"))
			accountServe.changeStatustoUnLocked(request.getParameter("haccountid"));
		else
			accountServe.changeStatustoLocked(request.getParameter("haccountid"));

		a = accountServe.getDetails(request.getParameter("husername"));
		
		request.setAttribute("u", a);
		request.getRequestDispatcher("admin_users.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
