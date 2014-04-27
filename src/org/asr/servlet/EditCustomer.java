package org.asr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.asr.model.Customer;
import org.asr.utility.SessionFactoryUtility;
import org.hibernate.Query;
import org.hibernate.Session;


@WebServlet("/EditCustomer")
public class EditCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			Session session = SessionFactoryUtility.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			String hql= "from Customer where id= :customer_id";
			Query query = session.createQuery(hql);
			query.setParameter("customer_id", Integer.parseInt(request.getParameter("id")));
			List<Customer> list=query.list();
			Customer customer=list.get(0);
			session.close();
			request.setAttribute("editCustomer", customer);
			request.getRequestDispatcher("/jsp/edit.jsp").forward(request, response);
			
						
		}
		catch(Exception e){
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Sorry! Unable to update the customer record");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			//Customer customer = (Customer)request.getAttribute("editCustomer");
			
			
			Session session = SessionFactoryUtility.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			String hql="update Customer set firstname=:cust_firstname,lastname=:cust_lastname,balance=:cust_balance,email=:cust_email where id=:cust_id";
			Query query = session.createQuery(hql);
			query.setParameter("cust_firstname",request.getParameter("firstname"));
			query.setParameter("cust_lastname",request.getParameter("lastname"));
			query.setParameter("cust_balance", Double.parseDouble(request.getParameter("balance")));
			query.setParameter("cust_email", request.getParameter("email"));
			query.setParameter("cust_id",Integer.parseInt(request.getParameter("id")));			
			query.executeUpdate();
			session.getTransaction().commit();
			response.getWriter().println("<h3><font color=\"blue\">1 customer record updated</font></h3><br>");
			response.getWriter().println("<a href=\"index.jsp\">| Home |</a>");
		}
		catch(Exception e){
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Sorry! Unable to update the customer record");
		}
		
		
	}

}
