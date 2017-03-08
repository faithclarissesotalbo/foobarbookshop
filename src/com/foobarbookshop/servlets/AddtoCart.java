package com.foobarbookshop.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foobarbookshop.beans.Product;
import com.foobarbookshop.services.ProductService;

/**
 * Servlet implementation class AddtoCart
 */
@WebServlet("/AddtoCart")
public class AddtoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddtoCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean same = false;
		HttpSession session = request.getSession(true);		
		Product p = new Product();	
		List<Product> cart= (List<Product>) session.getAttribute("cart");

		p = ProductService.getProduct(request.getParameter("title"));
		
		// sa session mo ilalagay yung cart
		if (cart == null) 
			cart = new ArrayList<Product>();
		
		for (int i = 0; i < cart.size(); i++){
			//if same sa product id ng nasa cart = add nlng doon
			if (cart.get(i).getProductid().equals(p.getProductid())) {
				cart.get(i).setQty(Integer.parseInt(request.getParameter("qty")) + cart.get(i).getQty());
				same = true;
			}
		}
		
		if (!same){
			p.setQty(Integer.parseInt(request.getParameter("qty")));
			cart.add(p);
		}
		session.setAttribute("cart", cart);
		
		//System.out.println(session.getAttribute("cart"));
		request.getRequestDispatcher("shop-shopping-cart.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
