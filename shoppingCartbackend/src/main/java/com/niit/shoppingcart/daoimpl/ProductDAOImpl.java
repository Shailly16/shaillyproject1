package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product1;


public class ProductDAOImpl implements ProductDAO {
	@Autowired
	public SessionFactory sessionfactory;
	public ProductDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionfactory = sessionfactory;
	}

	public List<Product1> list() {
		
		return null;
	}

	public Product1 get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product1 validate(String id) {
		return(Product1)sessionfactory.getCurrentSession().get(Product1.class, id);	
		
	}

	public boolean save(Product1 Product1) {
		try {
			sessionfactory.getCurrentSession().save(Product1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Product1 Product1) {
		try {
			sessionfactory.getCurrentSession().update(Product1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
			
	}


