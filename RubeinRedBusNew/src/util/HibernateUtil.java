package util;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	 private static final SessionFactory sessionFactory = buildSessionFactory1();

	    private static SessionFactory buildSessionFactory1() {
	        try {
	            // Create the SessionFactory from hibernate.cfg.xml
	            Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
				return    cfg.buildSessionFactory(
	            		new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build());
	        }
	        catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	        	
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }

}
