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
import com.foobarbookshop.beans.Address;
import com.foobarbookshop.beans.Card;
import com.foobarbookshop.beans.Product;
import com.foobarbookshop.services.AccountService;

/**
 * Servlet implementation class UpdateAccount
 */
@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
/*		System.out.println(session.getAttribute("user") == null);
*/		if (session.getAttribute("user") == null)
			request.getRequestDispatcher("page-login.jsp").forward(request, response);
		
		Account account = (Account) session.getAttribute("member");

		Account a = new Account();
		Address ad = new Address();
		Card c = new Card();
		ArrayList<Address> baddresses = new ArrayList<>();
		ArrayList<Card> cards = new ArrayList<>();
		AccountService accountServe = new AccountService();
		
		c.setCardnum(request.getParameter("cardnum"));
		c.setExpiredate(request.getParameter("expiredate"));
		c.setName(request.getParameter("name"));
		c.setType(request.getParameter("type"));
		cards.add(c);
		
		ad.setCity(request.getParameter("city"));
		ad.setCountry(request.getParameter("country"));
		ad.setHomenum(request.getParameter("homenum"));
		ad.setPostalcode(request.getParameter("postalcode"));
		ad.setStreet(request.getParameter("street"));
		ad.setSubdivision(request.getParameter("subdivision"));
		baddresses.add(ad);

		a.setEmail(request.getParameter("email"));
		a.setFirstname(request.getParameter("firstname"));
		a.setLastname(request.getParameter("lastname"));
		a.setMidinitial(request.getParameter("midinitial"));
		a.setPassword(request.getParameter("password"));
		a.setType(request.getParameter("accountype"));
		a.setUsername(request.getParameter("username"));
		a.setStatus(request.getParameter("status"));
		a.setBaddresses(baddresses);
		a.setCards(cards);

		
		
		if (session.getAttribute("role").equals("admin") || session.getAttribute("role").equals("accntmgr") ||
				session.getAttribute("role").equals("prdctmgr")){
			a.setAccountid(request.getParameter("accountid"));
			
			a = accountServe.editProfile(a);
			request.setAttribute("u", a);
			request.getRequestDispatcher("admin-users.jsp").forward(request,response);
		} else {
			a.setAccountid(account.getAccountid());
			
			a = accountServe.editProfileCust(a);
			request.setAttribute("member", a);
			request.getRequestDispatcher("shop-edit-profile.jsp").forward(request,response);
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
