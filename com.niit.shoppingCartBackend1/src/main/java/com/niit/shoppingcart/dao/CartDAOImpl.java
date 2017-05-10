package com.niit.shoppingcart.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.dao.CartDAO;
@Repository
public class CartDAOImpl implements CartDAO {
	
	static Logger log = LoggerFactory.getLogger(CartDAOImpl.class);

	private SessionFactory sessionFactory;
		
			
		

		@Autowired
		public CartDAOImpl(SessionFactory sessionFactory) {
			
				try {
					this.sessionFactory = sessionFactory;
					log.info(" The connection is established properly..");
				} catch (Exception e) {
					log.error("Not able to prepare connection.  Please check application"
							+ "context java file");
					e.printStackTrace();
				}
			
		}

	
	@Transactional
	public Cart getCartById(int cartId) {
		Session session=sessionFactory.getCurrentSession();
		
		return (Cart)session.get(Cart.class,new Integer(cartId));
		
	}	
	
	
	
	@Transactional
	public List<Cart> list(String UserID) {
		log.debug("Starting of the method list");
		String hql = "from Cart where userID="+"'"+UserID+"'"+" and status="+ "'N'";
		
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        log.debug("Ending of the method list");
        return query.list();
	}
	
	
	@Transactional
	public void save(Cart myCart) {
		log.debug("Starting of the method : save ");
		sessionFactory.getCurrentSession().save(myCart);
		log.debug("Ending of the method : save ");
	}
	
	@Transactional
	 public long getTotalAmount(String UserID)
	 {
		 log.debug("Starting of the getTotalAmount");
		 String hql = "from Cart where UserID="+"'"+UserID+"'"+" and status="+ "'N'";
		 log.debug("hql"+hql);
			
	      Query query = sessionFactory.openSession().createQuery(hql);
	      Long sum = (Long)query.uniqueResult();
	      log.debug("sum="+sum);
	      return sum;
		 
	 }

    @Transactional
	public void delete(Cart MyCart) {
		log.debug("Starting of the method : delete");
		sessionFactory.getCurrentSession().delete(MyCart);
		log.debug("Ending of the method : delete ");
		
	}


	public void updateCart(Cart myCart) {
		 
			log.debug("Starting of the method : update ");
			sessionFactory.getCurrentSession().update(myCart);
			log.debug("Ending of the method : update ");
		
	}

}
	


	/*private Long getMaxId() {
		
		 log.debug("Starting of the getMaxId");
		 Long maxID = 100L;
		 try{
		 String hql = "select max(id) from MyCart";
		 Query query = sessionFactory.getCurrentSession().createQuery(hql);
	     maxID = (Long) query.uniqueResult();}
	     catch(HibernateException e)
	     {
	       log.debug("Ending of the getTotalAmount");
	       maxID = 100L;
	       e.printStackTrace();}
	
	       return maxID;
	*/
	


	

	

