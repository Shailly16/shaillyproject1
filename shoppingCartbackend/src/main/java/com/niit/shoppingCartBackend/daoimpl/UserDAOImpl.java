package com.niit.shoppingCartBackend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingCartBackend.dao.UserDAO;
import com.niit.shoppingCartBackend.model.User1;

public class UserDAOImpl implements UserDAO {
	
	// require session factory
	@Autowired
	public SessionFactory sessionFactory;   // to do operations on database we need session factory
	// how to initialize
	// At the time of creation of instance you need to pass session factory
	public UserDAOImpl(SessionFactory sessionFactory)
	{ this.sessionFactory = sessionFactory;
	}
	

	public List<User1> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public User1 get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User1 validate(String id, String Password) {
	return(User1)sessionFactory.getCurrentSession().get(User1.class, id);
		
	}

	public boolean save(User1 User1) {
	
		
		try {
			sessionFactory.getCurrentSession().save(User1);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	return true;	// if statement is successful return true , hence false
	}
	

	public boolean update(User1 User1) {
		try {
			sessionFactory.getCurrentSession().update(User1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	

}
