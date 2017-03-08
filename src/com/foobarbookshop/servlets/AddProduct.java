package com.foobarbookshop.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foobarbookshop.beans.Product;
import com.foobarbookshop.services.BookService;
import com.foobarbookshop.services.ProductService;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
/*		if (session.getAttribute("user") == null || !session.getAttribute("role").equals("admin") || 
				!session.getAttribute("role").equals("accntmgr") || !session.getAttribute("role").equals("prdctmgr"))
			request.getRequestDispatcher("page-login.jsp").forward(request, response);*/
		
		String productid = null;
		Product p = new Product();
			
		p.setTitle(request.getParameter("producttitle"));
		p.setDescription(request.getParameter("productdesc"));
		p.setGenre(request.getParameter("productgenre"));
		p.setStock(request.getParameter("productstock"));
		p.setType(request.getParameter("producttype"));
		p.setPrice(request.getParameter("productprice"));
		p.setAcquiredate(request.getParameter("productacquiredate"));
		
		ProductService productServe = new ProductService();
		productid = productServe.addProduct(p);

		// later on plug in the services per product
		if (request.getParameter("producttype").equals("book")){
			BookService.addBook(productid, request.getParameter("productauthor"));
		} else if (request.getParameter("producttype").equals("magazine"))
			System.out.println("magazine");
		else if (request.getParameter("producttype").equals("audio_cd"))
			System.out.println("audio_cd");
		else if (request.getParameter("producttype").equals("dvd"))
			System.out.println("dvd");		

		request.getRequestDispatcher("admin-add-product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
