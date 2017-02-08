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

import com.niit.shoppingcart.dao.OrderDAO;
import com.niit.shoppingcart.model.Order;


@Repository
public class OrderDAOImpl implements OrderDAO {
	
	static Logger log = LoggerFactory.getLogger(CartDAOImpl.class);

private SessionFactory sessionFactory;
	
		
	

	@Autowired
	public OrderDAOImpl(SessionFactory sessionFactory) {
		
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
	public List<Order> list() {
		log.debug("Starting of the method list");
		String hql = "from Order";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        log.debug("Ending of the method list");
	   return query.list();
	}
	
	@Transactional
	public Order save(Order order) {
		log.debug("Starting of the method : save ");
		
		try {
			sessionFactory.getCurrentSession().save(order);
			log.debug("Ending of the method : save ");
		} catch (HibernateException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return null;
	}


	public Order get(String id) {
		String hql = "from Order";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Order> list = (List<Order>)query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}


	public Long getTotalAmount(String id) {
		 
		 {
			 String hql = "from Order where userID="+"'" +id+"'";
			 Query query = sessionFactory.getCurrentSession().createQuery(hql);
			 Long sum = (Long) query.uniqueResult();
			 return sum;
		 }
			 
				
		
	}
}
