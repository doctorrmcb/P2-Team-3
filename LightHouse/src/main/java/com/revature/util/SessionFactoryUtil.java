package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryUtil {
		
	private static SessionFactory sf;
	
	static {
		/*
		 * Configuration configuration = new Configuration().configure();
		 * ServiceRegistry serviceRegistry = new
		 * StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
		 * .build(); sf = configuration.buildSessionFactory(serviceRegistry);
		 */
		
		try {
            // Create the SessionFactory from hibernate.cfg.xml
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder() .configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            sf = metadata.getSessionFactoryBuilder().build();
        } 
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}


	public static SessionFactory getSessionFactory() {
		return sf;
	}

	@Autowired
	public static void setSf(SessionFactory sf) {
		SessionFactoryUtil.sf = sf;
	}
	
	
}
