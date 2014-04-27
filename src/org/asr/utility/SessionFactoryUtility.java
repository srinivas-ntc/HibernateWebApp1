package org.asr.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtility {
	 private static final SessionFactory sessionFactory;
		
	    static {
	      try {
	          Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	          StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
	          sb.applySettings(cfg.getProperties());
	          StandardServiceRegistry standardServiceRegistry = sb.build();
	          sessionFactory = cfg.buildSessionFactory(standardServiceRegistry); 

	        } catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	 public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
}
