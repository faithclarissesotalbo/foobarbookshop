package com.foobarbookshop.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foobarbookshop.beans.Account;
import com.foobarbookshop.beans.Item;
import com.foobarbookshop.services.TransactionService;

/**
 * Servlet implementation class DisplayAllTransactions
 */
@WebServlet("/DisplayAllTransactions")
public class DisplayAllTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllTransactions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		Account a = (Account) session.getAttribute("member");
		ArrayList<Item> items = new ArrayList<>();
		TransactionService transactionServe = new TransactionService();
		
		items = transactionServe.getPurchasingHistory(a.getAccountid());
		request.setAttribute("items", items);
		
		request.getRequestDispatcher("shop-purchase-history.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
