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

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product1;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
  Logger log = LoggerFactory.getLogger("Product1.class");
	
	//Logger log = LoggerFactory.getLogger("com.niit.shopingcart.dao.ProductDAOImpl");
  
	 
	@Autowired
	private SessionFactory sessionFactory;
	
		
	public ProductDAOImpl()
	{
		
	}


	public ProductDAOImpl(SessionFactory sessionFactory) {
		
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
	public List<Product1> list() {
		String hql = "from Product1";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();	
	}
	
	@Transactional
	public Product1 get(String id) {
		log.debug("Starting of the method : get ");
		String hql = "from Product1 where id=" + "'"+ id+"'";
		System.out.println(id);
		return (Product1)sessionFactory.getCurrentSession().get(Product1.class, id);
		
		
	}
	
	@Transactional
	public Product1 getProductByName(String name) {
		log.debug("Starting of the method : getProductByName ");
		String hql = "from Product1 where name1=" + "'"+ name+"'";
		System.out.println(name);
		return (Product1)sessionFactory.getCurrentSession().get(Product1.class, name);
		
		
	}
		

	@Transactional
	public boolean save(Product1 product) {
		log.debug("Starting of the method : save ");
		try {
			sessionFactory.getCurrentSession().save(product);
			log.debug("Ending of the method : save ");
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	@Transactional
	public boolean update(Product1 product) {
		log.debug("Starting of the method : save ");
		try {
			sessionFactory.getCurrentSession().update(product);
			log.debug("Ending of the method : save ");
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@Transactional
	public void delete(String id) {
		log.debug("Starting of the method : delete ");
		try {
			Product1 product = new Product1();
			product.setId(id);
			sessionFactory.getCurrentSession().delete(product);
			log.debug("Ending of the method : delete ");
		} catch (HibernateException e) {
			log.error("Not able to delete the record:" + e.getMessage());
			e.printStackTrace();
		}
	}

	
	
	
	public Product1 getProductDetails()
	{
		String hql = "from Product1";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Product1> list = (List<Product1>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
		
	}


	
	


	
	
	
}











	

