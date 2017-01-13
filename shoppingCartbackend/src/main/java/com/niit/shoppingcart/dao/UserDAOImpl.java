package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User1;

@Repository
public class UserDAOImpl implements UserDAO {
	Logger log = LoggerFactory.getLogger("UserDAOImpl.class");
	// require session factory
	@Autowired
	private SessionFactory sessionFactory;   // to do operations on database we need session factory
	// how to initialize
	// At the time of creation of instance you need to pass session factory
	public UserDAOImpl()
	{
		
	}
	public UserDAOImpl(SessionFactory sessionFactory)
	{ 
		try {
			this.sessionFactory = sessionFactory;
			log.info(" The connection is established properly..");
		} catch (Exception e) {
			log.error("Not able to prepare connection.  Please check application"
					+ "context java file");
			e.printStackTrace();
		}
	
}
		                                                                              //this.sessionFactory = sessionFactory;
	
	

	@Transactional
	public List<User1> list() {
		String hql = "from User1";
        Query query =	sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();	
	}
	                                                                                        /*String hql = "from User11";
	                                                       Query query =	sessionFactory.getCurrentSession().createQuery(hql);
	                                                                                           return query.list();*/
                                                                                         //convert in db specific language
		
	
@Transactional
	public User1 get(String id) {
	log.debug("Starting of the method : get ");
	String hql = "from User1where id=" + "'"+ id+"'";
	System.out.println(id);
	return (User1)sessionFactory.getCurrentSession().get(User1.class, id);}

@Transactional
public User1 getUserByName(String name) {
	log.debug("Starting of the method : getUser1ByName ");
	String hql = "from User1where name1=" + "'"+ name+"'";
	System.out.println(name);
	return (User1)sessionFactory.getCurrentSession().get(User1.class, name);
	
}
	
	                                                                                           /*System.out.println(id);
		                                                 return(User1)sessionFactory.getCurrentSession().get(User1.class, id);*/
		
	
                                                                                                // invalid return null
                                                                                       //valid will return user domain object
    @Transactional
	public User1 validate(String id, String password) 
    {
    	log.debug("Starting of the method : isValidUser1 ");
		log.info("The user id :" + id);
		
		// Select * from User1 where id = 'id' and password = 'password';
		String hql = "from User1 where id = "  +  "'"  + id + "'"   +  " and "
		  + "password = "  + "'"  +  password  + "'";
		Query query =	sessionFactory.getCurrentSession().createQuery(hql);
		log.info(" The query is :" + hql);
		
		
		 return(User1) query.uniqueResult();
    }
	                                                   
    	
	                                                     /* Query query =	sessionFactory.getCurrentSession().createQuery(hql);
	                                                                     return(User11) query.uniqueResult();*/
    
	 
                                                                            /*@Transactional
	                                                                  public boolean save(User1user) {
	
		
		                                                              try {
			                                                             sessionFactory.getCurrentSession().save(user);
		                                                                      } catch (HibernateException e) {
			                                                                 
			                                                                        e.printStackTrace();
			                                                                           return false;}
		
	                                                    return true;	// if statement is successful return true , hence false*/
	


public User1 getUserDetails()
{ 
	String hql = "from User1";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<User1> list = (List<User1>) query.list();
	
	if (list != null && !list.isEmpty()) {
		return list.get(0);
	}
	
	return null;
	
}

@Transactional
public boolean save(User1 user) {
	log.debug("Starting of the method : saveOrUpdate ");
	try {
		sessionFactory.getCurrentSession().save(user);
		log.debug("Ending of the method : save ");
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
	return true;
}



@Transactional
public void delete(String id) {
	log.debug("Starting of the method : delete ");
	try {
		User1 user = new User1();
		user.setId(id);
		sessionFactory.getCurrentSession().delete(user);
		log.debug("Ending of the method : delete ");
	} catch (HibernateException e) {
		log.error("Not able to delete the record:" + e.getMessage());
		e.printStackTrace();
	}

	
	
}
@Transactional
public boolean update(User1 user) {
	log.debug("Starting of the method : Update ");
	try {
		sessionFactory.getCurrentSession().update(user);
		log.debug("Ending of the method : Update ");
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
	
	return true;
}



	

}




