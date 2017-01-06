package com.niit.shoppingcart.daoimpl;

import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category1;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	// require session factory
	@Autowired
	private SessionFactory sessionFactory;   // to do operations on database we need session factory
	// how to initialize
	// At the time of creation of instance you need to pass session factory
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{ 
		this.sessionFactory = sessionFactory;
	}
	

	@Transactional
	public List<Category1> list() {
	String hql = "from Category1";
	Query query =	sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
//convert in db specific language
		
	}
@Transactional
	public Category1 get(String id) {
		// TODO Auto-generated method stub
	System.out.println(id);
		return(Category1)sessionFactory.getCurrentSession().get(Category1.class, id);
		
	}

	 
    @Transactional
	public boolean save(Category1 user) {
	
		
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
	public boolean update(Category1 user) {
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
