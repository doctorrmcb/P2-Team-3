package com.revature.util;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionFactoryConfig {

	@Bean
	public SessionFactory sessionFactory() {
		return SessionFactoryUtil.getSessionFactory();
	}
}
