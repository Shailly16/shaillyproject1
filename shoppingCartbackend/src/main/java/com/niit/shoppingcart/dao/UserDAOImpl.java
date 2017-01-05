package com.niit.shoppingcart.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User1;

@Repository


public class UserDAOImpl implements UserDAO {
	
	// require session factory
	@Autowired
	public SessionFactory sessionFactory;   // to do operations on database we need session factory
	// how to initialize
	// At the time of creation of instance you need to pass session factory
	public UserDAOImpl(SessionFactory sessionFactory)
	{ this.sessionFactory = sessionFactory;
	}
	

	@Transactional
	public List<User1> list() {
	String hql = "from User1";
	Query query =	sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
//convert in db specific language
		
	}
@Transactional
	public User1 get(String id) {
		// TODO Auto-generated method stub
	System.out.println(id);
		return(User1)sessionFactory.getCurrentSession().get(User1.class, id);
		
	}
// invalid return null
//valid will return user domain object
    @Transactional
	public boolean validate(String id, String password) {
	String hql = "select * from user1 where id='"+id+"'and password='"+password+"'";
	Query query =	sessionFactory.getCurrentSession().createQuery(hql);
	 User1 u1=(User1)query.uniqueResult();
	 System.out.println("The User ID is :"+u1.getId());
	 if(u1 !=null)
	 {
		 return true;
	 }
	 else
	 {
		 return false;
	 }	
	}
    @Transactional
	public boolean save(User1 user) {
	
		
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	return true;	// if statement is successful return true , hence false
	}
	
@Transactional
	public boolean update(User1 user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	

}
