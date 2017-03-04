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
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.CartList;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Item;
import com.niit.shoppingcart.model.MyCart;

import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Shopping;
import com.niit.shoppingcart.model.Supplier;

import com.niit.shoppingcart.model.User;




@Configuration
@ComponentScan("com.niit.shoppingcart")
@EnableTransactionManagement
public class ApplicationContextConfig 
{
	@Bean("dataSource")
	public DataSource getH2dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/shail");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	

public Properties getHibernateProperties()
{
	Properties properties = new Properties();
	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	properties.put("hibernate.show_sql", "true");
	 properties.put("hibernate.format_sql",true);
     properties.put("hibernate.hbm2ddl.auto", "update");
	

	return properties;
	
}

@Autowired
@Bean("sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource) {

	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.addAnnotatedClass(User.class);
	sessionBuilder.addAnnotatedClass(Supplier.class);
	sessionBuilder.addAnnotatedClass(Product.class);
	sessionBuilder.addAnnotatedClass(Category.class);
	sessionBuilder.addAnnotatedClass(Cart.class);
	sessionBuilder.addAnnotatedClass(CartList.class);
	sessionBuilder.addAnnotatedClass(Item.class);
	sessionBuilder.addAnnotatedClass(Shopping.class);
	/*sessionBuilder.addAnnotatedClass(MyCart.class);*/
/*	sessionBuilder.addAnnotatedClass(Order.class);*/
	sessionBuilder.scanPackages("com.niit.shoppingcart.model" );
	
	return sessionBuilder.buildSessionFactory();
}






@Bean("transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
	HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	
	transactionManager.setSessionFactory(sessionFactory);
	return transactionManager;
	
}
}

