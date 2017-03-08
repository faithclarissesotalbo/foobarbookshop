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
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
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
		
		Product p = new Product();
		ProductService productServe = new ProductService();	
		
		p.setTitle(request.getParameter("producttitle"));
		p.setDescription(request.getParameter("productdesc"));
		p.setGenre(request.getParameter("productgenre"));
		p.setStock(request.getParameter("productstock"));
		p.setType(request.getParameter("producttype"));
		p.setPrice(request.getParameter("productprice"));
		p.setAcquiredate(request.getParameter("productacquiredate"));
		p.setProductid(request.getParameter("productid"));
			
		p = productServe.editProduct(p);
		
		request.setAttribute("product", p);
		request.getRequestDispatcher("FindProduct?type=" + request.getParameter("producttype")).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
