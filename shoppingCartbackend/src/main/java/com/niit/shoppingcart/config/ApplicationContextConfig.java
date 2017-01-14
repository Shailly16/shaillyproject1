package com.niit.shoppingcart.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcart.model.Category1;
import com.niit.shoppingcart.model.Product1;
import com.niit.shoppingcart.model.Supplier1;
import com.niit.shoppingcart.model.User1;




@Configuration
@ComponentScan("com.niit.shoppingcart")
@EnableTransactionManagement
public class ApplicationContextConfig 
{
	@Bean(name="dataSource")
	public DataSource getH2dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}

private Properties getHibernateProperties()
{
	Properties properties = new Properties();
	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	properties.put("hibernate.show_sql", "true");
	 properties.put("hibernate.format_sql",true);
     properties.put("hibernate.hbm2ddl.auto", "create");
	

	return properties;
	
}

@Autowired
@Bean(name = "sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource) {

	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.addAnnotatedClass(User1.class);
	sessionBuilder.addAnnotatedClass(Supplier1.class);
	sessionBuilder.addAnnotatedClass(Product1.class);
	sessionBuilder.addAnnotatedClass(Category1.class);
	sessionBuilder.scanPackages("com.niit.shoppingcart.model" );
	
	return sessionBuilder.buildSessionFactory();
}


	
	

@Autowired
@Bean(name = "transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
	HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	
	transactionManager.setSessionFactory(sessionFactory);
	return transactionManager;
	
}
}

