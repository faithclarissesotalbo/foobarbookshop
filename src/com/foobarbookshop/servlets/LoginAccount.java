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
import com.foobarbookshop.beans.Login;
import com.foobarbookshop.services.AccountService;
import com.foobarbookshop.services.LoginService;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/LoginAccount")
public class LoginAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// if naka log in ka na, diretso na agad sa dashboard
		HttpSession session = request.getSession(true);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String status;
		
		AccountService userServe = new AccountService();
		LoginService loginServe = new LoginService();
		
    	Account u = new Account();
    	u = userServe.getDetails(request.getParameter("username"));
    	System.out.println(u.getUsername());
    	ArrayList<Login> loginlist = loginServe.get3LoginAttempts(u.getAccountid());

    	if(loginServe.checkLogin(username, password)){
        	status = "success";
        	
        	if(u.getStatus().equals("unlocked")){
        		loginServe.addLoginAttempt(u.getAccountid(), status);
            	
        		session.setAttribute("member", u);
        		//System.out.println("dito: " + u.getBaddresses().get(0).getCity());
        		//bruteforce = setting role in session
        		session.setAttribute("role", u.getType());
        		session.setAttribute("user", request.getParameter("username"));
        		
        		if (u.getType().equals("admin") || u.getType().equals("accntmgr") || u.getType().equals("prdctmgr"))
        			request.getRequestDispatcher("admin-index.jsp").forward(request,response);
        		else 
        			request.getRequestDispatcher("shop-index.jsp").forward(request,response);
        	}
        	else{
        		
        		int mins = loginServe.minAfterLastFail(loginlist.get(0).getTimestamp());
        		if(mins >= 15){
        			userServe.changeStatustoUnLocked(u.getAccountid());
        			
        			loginServe.addLoginAttempt(u.getAccountid(), status);
                	
            		session.setAttribute("member", u);
            		//bruteforce = setting role in session
            		session.setAttribute("role", u.getType());
            		session.setAttribute("user", request.getParameter("username"));
            		
            		if (u.getType().equals("admin") || u.getType().equals("accntmgr") || u.getType().equals("prdctmgr"))
            			request.getRequestDispatcher("admin-index.jsp").forward(request,response);
            		else 
            			request.getRequestDispatcher("shop-index.jsp").forward(request,response);
        		} else{
        			response.getWriter().append("Served at: " + mins + "  ").append(request.getContextPath());
        		}
        	}
        	
        } else {
        	status = "fail";
        	boolean found = false;
        	int loginattempts = loginServe.totalDailyAttempts(u.getAccountid());
        	
        	System.out.println("wrong pass/user");
        	System.out.println(loginattempts + "loginattempts");
        	
        	if (loginattempts >= 3){
        		for (int i = 0; i < loginlist.size(); i ++){
        			if (loginlist.get(i).getStatus().equals("success")){
        				found = true;
        				break;
        			}
        			System.out.println(loginlist.get(i).getStatus());
        		}
        		
        		if(found == false){
        			userServe.changeStatustoLocked(u.getAccountid());
        			
        			int mins = loginServe.minAfterLastFail(loginlist.get(0).getTimestamp());
        			
        			response.getWriter().append("Served at: " + mins + "  ").append(request.getContextPath());
        		} else {
        			loginServe.addLoginAttempt(u.getAccountid(), status);
        			request.getRequestDispatcher("page-login.jsp?mode=locked").forward(request,response); 
        		}
        		
        		//System.out.println("forbidden for 15mins");
        	} else
        		request.getRequestDispatcher("page-login.jsp?mode=error").forward(request,response);  
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
