package com.foobarbookshop.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foobarbookshop.beans.Product;
import com.foobarbookshop.services.ProductService;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/Redirect")
public class Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Redirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

	/*		if (session.getAttribute("user") == null || !session.getAttribute("role").equals("admin") || 
				!session.getAttribute("role").equals("accntmgr") || !session.getAttribute("role").equals("prdctmgr"))
			request.getRequestDispatcher("page-login.jsp").forward(request, response);*/
		
		Product p = new Product();
		ProductService productServe = new ProductService();
		
		if (request.getParameter("mode").equals("edit")){
			p = productServe.getProduct(request.getParameter("productid"));
			
			request.setAttribute("product", p);
			request.getRequestDispatcher("admin-add-product.jsp").forward(request, response);
		}
		else {
			String filter = request.getParameter("type");
			productServe.deleteProduct(request.getParameter("productid"));
			
			request.getRequestDispatcher("DisplayAllProducts?type=" + filter).forward(request, response);
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
