package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.MyCart;
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
	public List<MyCart> list(String userID) {
		log.debug("Starting of the method list");
		String hql = "from MyCart where userID="+"'"+userID+"'"+" and status="+ "'N'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        log.debug("Ending of the method list");
        return query.list();
	}
	
	@Transactional
	public void save(MyCart myCart) {
		log.debug("Starting of the method : save ");
		myCart.setId(getMaxId());
		sessionFactory.getCurrentSession().save(myCart);
		log.debug("Ending of the method : save ");
	}
	
	 public long getTotalAmount(String userID)
	 {
		 log.debug("Starting of the getTotalAmount");
		 String hql = "from MyCart where userID="+"'"+userID+"'"+" and status="+ "'N'";
		 log.debug("hql"+hql);
			
	      Query query = sessionFactory.getCurrentSession().createQuery(hql);
	      Long sum = (Long)query.uniqueResult();
	      log.debug("sum="+sum);
	      return sum;
		 
	 }


	private Long getMaxId() {
		
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
	
}


	

	
}