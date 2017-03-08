package com.foobarbookshop.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
/*@WebServlet(urlPatterns={"/Controller", "/Main", "/LoginAccount"})*/
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		process(request,response);
*/		
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("user") == null || session.getAttribute("user") != null)
			request.getRequestDispatcher("shop-index.jsp").forward(request, response);
		else if (session.getAttribute("role").equals("admin") || session.getAttribute("role").equals("acctmgr") || session.getAttribute("role").equals("prdctmgr"))
			request.getRequestDispatcher("admin-index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		process(request, response);
*/	
		doGet(request,response);
	}
	
/*	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action){
			case "/Main": request.getRequestDispatcher("shop-index.jsp").forward(request, response);
			case "/LoginAccount": System.out.println("dito nagpunta");
						break;
			//default: request.getRequestDispatcher("shop-index.jsp").forward(request, response);
			
		}	
	}*/
}
