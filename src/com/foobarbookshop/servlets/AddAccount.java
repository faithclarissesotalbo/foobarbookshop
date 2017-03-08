package com.foobarbookshop.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foobarbookshop.beans.Account;
import com.foobarbookshop.beans.Address;
import com.foobarbookshop.beans.Billing;
import com.foobarbookshop.beans.Card;
import com.foobarbookshop.beans.Delivery;
import com.foobarbookshop.beans.Password;
import com.foobarbookshop.services.AccountService;
import com.foobarbookshop.services.AddressService;
import com.foobarbookshop.services.BillingService;
import com.foobarbookshop.services.CardService;
import com.foobarbookshop.services.DeliveryService;
import com.foobarbookshop.services.PasswordService;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get all input of the user and create a USER object
		Account u = new Account();

		//checking if username is unique
		boolean notUnique = false;
		
		//call service to add the object
		AccountService userServe = new AccountService();

		notUnique = userServe.checkUnique(request.getParameter(Account.COLUMN_USERNAME));
		
		request.setAttribute("user", u);		
/*		request.getRequestDispatcher("Controller").forward(request,response);
*/		
		System.out.println("status " + notUnique); //if unique sya
		if (notUnique == false) {
			String accountid = null;
			String addressid =  null;
			
			ArrayList<Address> baddresses = new ArrayList<Address>();
			ArrayList<Card> cards = new ArrayList<Card>();
			
			Address a = new Address();
			Card c = new Card();			
			Billing b = new Billing();
			Delivery d = new Delivery();
			Password p = new Password();
			
			AddressService addressServe = new AddressService();
			CardService cardServe = new CardService();
			BillingService billingServe = new BillingService();
			DeliveryService deliveryServe = new DeliveryService();
			PasswordService passwordServe = new PasswordService();
					
			u.setUsername(request.getParameter(Account.COLUMN_USERNAME));
			u.setEmail(request.getParameter(Account.COLUMN_EMAIL));
			u.setFirstname(request.getParameter(Account.COLUMN_FIRSTNAME));
			u.setLastname(request.getParameter(Account.COLUMN_LASTNAME));		
			u.setMidinitial(request.getParameter(Account.COLUMN_MIDINITIAL));
			accountid = userServe.createAccount(u);

			p.setAccountid(accountid);
			p.setEncryptedpw(request.getParameter("password"));
			p.setHashedpw(request.getParameter("password"));
			passwordServe.createPassword(accountid, p);
			
			a.setCity(request.getParameter(Address.COLUMN_CITY));
			a.setCountry(request.getParameter(Address.COLUMN_COUNTRY));
			a.setHomenum(request.getParameter(Address.COLUMN_HOMENUM));
			a.setPostalcode(request.getParameter(Address.COLUMN_POSTALCODE));
			a.setStreet(request.getParameter(Address.COLUMN_STREET));
			a.setSubdivision(request.getParameter(Address.COLUMN_SUBDIVISION));
			baddresses.add(a);
			u.setBaddresses(baddresses);
			System.out.println("add accnt"+ u.getBaddresses().get(0).getCity());
			addressid = addressServe.addAddress(a);
			
			c.setAccountid(accountid);
			c.setCardid(request.getParameter(Card.COLUMN_CARDID));
			c.setCardnum(request.getParameter(Card.COLUMN_CARDNUM));
			c.setName(request.getParameter(Card.COLUMN_NAME));
			c.setType(request.getParameter(Card.COLUMN_TYPE));
			c.setExpiredate(request.getParameter(Card.COLUMN_EXPIREDATE));
			cards.add(c);
			cardServe.addCard(c);
			u.setCards(cards);
			c = cardServe.getCard(accountid);
			
			billingServe.addAddress(addressid, c.getCardid());
			deliveryServe.addDelivery(addressid, accountid);
			
			request.setAttribute("user", u);		
			request.getRequestDispatcher("Controller").forward(request,response);
		}
	}

}
