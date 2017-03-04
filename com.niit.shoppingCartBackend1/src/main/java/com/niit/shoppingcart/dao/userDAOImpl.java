package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.BillingAddress;
import com.niit.shoppingcart.model.User;



@Repository
public class UserDAOImpl implements UserDAO {
	
  Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	
	//Logger log = LoggerFactory.getLogger("com.niit.shopingcart.daoimpl.userDAOImpl");
  
	 
	@Autowired
	private SessionFactory sessionFactory;
	
		
	public UserDAOImpl()
	{
		
	}


	public UserDAOImpl(SessionFactory sessionFactory) {
		
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
	public List<User> list() {
		log.debug("Starting of the method list");
		String hql = "from user";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        log.debug("Ending of the method list");
	   return query.list();
	}

	@Transactional
	public boolean save(User user1) {
		log.debug("Starting of the method : save ");
		try {
			sessionFactory.getCurrentSession().save(user1);
			log.debug("Ending of the method : save ");
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	@Transactional
	public boolean update(User user1) {
		log.debug("Starting of the method : save ");
		try {
			sessionFactory.getCurrentSession().update(user1);
			log.debug("Ending of the method : save ");
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	  @Transactional
		public User validate(String id, String password) 
	    {
	    	log.debug("Starting of the method : isValidUser ");
			log.info("The user id :" + id);
			String hql = "from User where id = '"  + id + "' and  password ='"  +  password  + "'";
			Query query =	sessionFactory.getCurrentSession().createQuery(hql);
			log.info(" The query is :" + hql);
			
			
			return (User)query.uniqueResult();
	    }
		                                                   
	    	
	@Transactional
	public void saveOrUpdate(User user1) {
		log.debug("Starting of the method : saveOrUpdate ");
		sessionFactory.getCurrentSession().save(user1);
			log.debug("Ending of the method : saveOrUpdate ");
		} 
	
	
	@Transactional
	public boolean delete(String id) {
		log.debug("Starting of the method : delete ");
		try {
			User user1 = new User();
			user1.setId(id);
			sessionFactory.getCurrentSession().delete(user1);
			log.debug("Ending of the method : delete ");
		} catch (HibernateException e) {
			log.error("Not able to delete the record:" + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public User get(String id) {
		log.debug("Starting of the method : get ");
		String hql = "from user where id=" + "'"+ id+"'";
		System.out.println(hql);
		return (User)sessionFactory.getCurrentSession().get(User.class, id);
		
		
	}
	
	@Transactional
	public User getByName(String name) {
		log.debug("Starting of the method : getuserByName ");
		String hql = "from user where name1=" + "'"+ name+"'";
		System.out.println(hql);
		return (User)sessionFactory.getCurrentSession().get(User.class, name);
		
		
	}
		
	
	
	

    @Transactional
	public User getUserDetails(String hql) {
    	return sessionFactory.getCurrentSession().get(User.class, hql);
	}


	public String insertAddress(BillingAddress address) {
		System.out.println("insert address");
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		s.saveOrUpdate(address);
		System.out.println("insert addresssss");
		t.commit();
		s.close();
		return "success";
	}


	

	
	
	
}










