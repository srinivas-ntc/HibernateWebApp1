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


@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Session session = SessionFactoryUtility.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			//String hql="delete from Customer where id= :cust_id";
			//Query query = session.createQuery(hql);
			//query.setParameter("cust_id", Integer.parseInt(request.getParameter("id")));
			//int result=query.executeUpdate();
			Customer customer = (Customer)session.load(Customer.class, Integer.parseInt(request.getParameter("id")));
			if(customer !=null){
				session.delete(customer);
				session.getTransaction().commit();
				response.getWriter().println("<h3><font color=\"red\">1 customer record deleted</font></h3>");
				response.getWriter().println("<a href=\"index.jsp\">"+"| Home |"+"</a>");
				return;
			}
			
			/*session.getTransaction().commit();
			if(result !=0){
				response.getWriter().println("<h3><font color=\"red\">1 customer record deleted</font></h3>");
				response.getWriter().println("<a href=\"index.jsp\">"+"| Home |"+"</a>");
				return;
			}*/
			else{
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "Invalid Customer ID");
				return;
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Unable to delete customer record");
		}
	}

}
