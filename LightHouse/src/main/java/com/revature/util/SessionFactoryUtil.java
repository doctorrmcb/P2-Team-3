package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryUtil {
		
	private static SessionFactory sf;
	
	static {
	Configuration configuration = new Configuration().configure();
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	sf = configuration.buildSessionFactory(serviceRegistry);
}


	public static SessionFactory getSessionFactory() {
		return sf;
	}

	@Autowired
	public static void setSf(SessionFactory sf) {
		SessionFactoryUtil.sf = sf;
	}
	
	
}
