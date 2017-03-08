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

/**
 * Servlet implementation class RemoveItem
 */
@WebServlet("/RemoveItem")
public class RemoveItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String id = request.getParameter("id");
		int index = 0;
		int i = 0;
		
		ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("cart");
		
		while (i < productList.size()) {
			if (productList.get(i).getProductid().equals(id))
				index = i;
			i++;
		}
		
		productList.remove(index);
		
		// reinitialize 
		session.setAttribute("cart", productList);
		System.out.println(session.getAttribute("cart"));
		
		if (productList.isEmpty())
			request.getRequestDispatcher("shop-shopping-cart-null.jsp").forward(request, response);
		else
			request.getRequestDispatcher("shop-shopping-cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
