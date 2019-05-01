package com.util;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfiguration 
{

    private static Logger log = Logger.getLogger(HibernateConfiguration.class);

    static Configuration config = null;
    static SessionFactory sessionFactory = null;

    static 
    {
		try 
		{
		    log.info( "Initiating Hibernate Configuration.");
	
		    config = new Configuration();
		    config.configure("hibernate.cfg.xml");
	
		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(getHibernateProperties())
			    .build();
		    sessionFactory = config.buildSessionFactory(serviceRegistry);
		    log.info( "Hibernate Configured succesfully.");
		}
		catch (Exception e) 
		{
		    e.printStackTrace();
		    log.error( "Exception : in HibernateConfiguration  " + e);
		}
    }
 
    public  static Session openHibernateSession() 
    {
		Session hibernateSession = null;
	
		try
		{
		    log.info( "Initiating Hibernate session.");
		    hibernateSession = sessionFactory.openSession();
		    log.info( "Hibernate session created.");
		} 
		catch (Exception e) 
		{
		    e.printStackTrace();
		    log.info( "exception while creating session object : " + e);
		}
	
		return hibernateSession;
    }

    public static void closeHibernateSession(Session hibernateSession) 
    {
    	hibernateSession.flush();
		hibernateSession.clear();
		hibernateSession.close();
		log.info( "Hibernate Session closed.");
    }
    
    private static Properties getHibernateProperties() {
    	
    	Properties properties = new Properties();
    	
    	properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/test?autoReconnect=true");
    	properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
    	properties.put("hibernate.connection.username", "root");
    	properties.put("hibernate.connection.password", "root");
    	
    	return properties;
    }
}
