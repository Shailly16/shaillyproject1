package com.niit.shoppingcart.daoimpl;

import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product1;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	// require session factory
	@Autowired
	private SessionFactory sessionFactory;   // to do operations on database we need session factory
	// how to initialize
	// At the time of creation of instance you need to pass session factory
	public ProductDAOImpl(SessionFactory sessionFactory)
	{ 
		this.sessionFactory = sessionFactory;
	}
	

	@Transactional
	public List<Product1> list() {
	String hql = "from Product1";
	Query query =	sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
//convert in db specific language
		
	}
 @Transactional
	public Product1 get(String id) {
		// TODO Auto-generated method stub
	System.out.println(id);
		return(Product1)sessionFactory.getCurrentSession().get(Product1.class, id);
		
	}

	 
    @Transactional
	public boolean save(Product1 user) {
	
		
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
	public boolean update(Product1 user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}


public Product1 validate(String id) {
	// TODO Auto-generated method stub
	return null;
}

	
	

}
