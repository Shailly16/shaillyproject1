package com.niit.shoppingcart.daoimpl;

import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier1;

@Repository
public class SupplierDAOImpl implements SupplierDAO {
	
	// require session factory
	@Autowired
	private SessionFactory sessionFactory;   // to do operations on database we need session factory
	// how to initialize
	// At the time of creation of instance you need to pass session factory
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{ 
		this.sessionFactory = sessionFactory;
	}
	

	@Transactional
	public List<Supplier1> list() {
	String hql = "from Supplier1";
	Query query =	sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
//convert in db specific language
		
	}
@Transactional
	public Supplier1 get(String id) {
		
	System.out.println(id);
		return(Supplier1)sessionFactory.getCurrentSession().get(Supplier1.class, id);
		
	}

@Transactional
	public boolean save(Supplier1 user) {
	
		
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	return true;	// if statement is successful return true , hence false
	}
	
@Transactional
	public boolean update(Supplier1 user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}


   public Supplier1 validate(String id) {
	
	return null;
}

	
	

}