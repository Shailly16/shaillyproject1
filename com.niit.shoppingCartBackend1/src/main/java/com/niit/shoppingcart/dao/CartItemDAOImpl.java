package com.niit.shoppingcart.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Item;
@Repository
public class CartItemDAOImpl implements CartItemDAO
{
	private SessionFactory sessionFactory; 
	
	@Autowired
	public CartItemDAOImpl(SessionFactory sessionFactory) 
	{
		super();
		this.sessionFactory = sessionFactory;
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public Item getCartItemByProductId(int productId) {
		Session session = sessionFactory.getCurrentSession();
		 
        Query query = session.createQuery("from Item where itemId = ?");
        query.setInteger(0, productId);
        session.flush();
      

        return (Item) query.uniqueResult();
    }

	
    @Transactional
	public void removeAllCartItems(Cart cart) {
		// TODO Auto-generated method stub
		
	}

}



