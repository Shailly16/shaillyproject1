package com.niit.shoppingcart.daoimpl;

import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User1;

@Repository
public class UserDAOImpl implements UserDAO {
	
	// require session factory
	@Autowired
	private SessionFactory sessionFactory;   // to do operations on database we need session factory
	// how to initialize
	// At the time of creation of instance you need to pass session factory
	public UserDAOImpl(SessionFactory sessionFactory)
	{ 
		this.sessionFactory = sessionFactory;
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
	public User1 validate(String id, String password) {
	String hql = "from User1 where id='"+id+"'and password='"+password+"'";
    	
	Query query =	sessionFactory.getCurrentSession().createQuery(hql);
	 return(User1) query.uniqueResult();
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
