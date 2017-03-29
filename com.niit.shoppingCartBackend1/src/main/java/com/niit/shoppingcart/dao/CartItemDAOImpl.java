package com.niit.shoppingcart.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Item;
@Repository
public class CartItemDAOImpl implements CartItemDAO
{
	static Logger log=LoggerFactory.getLogger(CartItemDAOImpl.class);
	private SessionFactory sessionFactory; 
	
	@Autowired
	public CartItemDAOImpl(SessionFactory sessionFactory) 
	{
		super();
		this.sessionFactory = sessionFactory;
		
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	 
	public Session getSession()
	{
		return sessionFactory.openSession();
	}
	
	@Transactional
	public void addCartItem(Item cartItem) {
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        //session.flush();

	}
     
	@Transactional
	public void removeCartItem(Item cartItem) {
		sessionFactory.getCurrentSession().delete(cartItem);
		
	}

	@Transactional
	public Item getCartItemByProductId(String productId) {
		Session session = sessionFactory.getCurrentSession();
		 
        Query query = session.createQuery("from Item where itemId = " +productId);
        
        
      

        return (Item) query.uniqueResult();
    }

	
   
}



