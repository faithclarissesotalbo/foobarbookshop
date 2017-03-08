package com.foobarbookshop.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foobarbookshop.beans.Account;
import com.foobarbookshop.beans.Item;
import com.foobarbookshop.beans.Product;
import com.foobarbookshop.beans.Transaction;
import com.foobarbookshop.services.ItemService;
import com.foobarbookshop.services.TransactionService;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Account a= (Account) session.getAttribute("member");
		List<Product> cart= (List<Product>) session.getAttribute("cart");
		Transaction t= new Transaction();
		TransactionService transactionServe = new TransactionService();
		
		transactionServe.addTransaction(a.getAccountid());
		
		Item i = new Item();
		ItemService itemServe = new ItemService();
		
		t = transactionServe.getTransaction(a.getAccountid());
		
		for (int j = 0; j < cart.size(); j++)
			itemServe.addItem(t.getTransactionID(), cart.get(j));
		
		// destroy session on cart 
		request.getSession().removeAttribute("cart");
		request.getRequestDispatcher("shop-account.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
