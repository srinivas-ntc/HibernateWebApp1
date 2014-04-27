package org.asr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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


@WebServlet("/ListCustomers")
public class ListCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try{
			Session session = SessionFactoryUtility.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery("from Customer");
			List<Customer> list = query.list();
			
			request.setAttribute("custlist", list);
			
			request.getRequestDispatcher("/jsp/listallcust.jsp").include(request,response);
			
			session.close();
			out.println("<br><a href=\"index.jsp\">| Home |</a>");
		
		}
		catch(Exception e){
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Sorry! Unable to  provide customer details");
		}
	}

}
