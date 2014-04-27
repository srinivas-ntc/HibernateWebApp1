package org.asr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.asr.model.Customer;
import org.asr.utility.SessionFactoryUtility;
import org.hibernate.Session;


@WebServlet("/NewCustomer")
public class NewCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer();
		try{
			customer.setFirstname(request.getParameter("firstname"));
			customer.setBalance(Double.parseDouble(request.getParameter("balance")));
			customer.setLastname(request.getParameter("lastname"));
			customer.setEmail(request.getParameter("email"));
			
			Session session = SessionFactoryUtility.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.persist(customer);
			session.getTransaction().commit();
			response.getWriter().println("1 customer record stored in the table");
		}
		catch(Exception e){
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Sorry! Unable to  store customer details");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
