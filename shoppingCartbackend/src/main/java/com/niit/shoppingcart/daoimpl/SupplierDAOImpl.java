package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier1;


public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	public SessionFactory sessionfactory;
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{ 
		this.sessionfactory = sessionFactory;
	}

	public List<Supplier1> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public Supplier1 get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Supplier1 validate(String id) {
		return(Supplier1)sessionfactory.getCurrentSession().get(Supplier1.class, id);
		
		
		
	}

	public boolean save(Supplier1 Supplier1) {
		
		try {
			sessionfactory.getCurrentSession().save(Supplier1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
		
	
public boolean update(Supplier1 Supplier1) {
	
	try {
		sessionfactory.getCurrentSession().update(Supplier1);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	return true;
}
		
	}


