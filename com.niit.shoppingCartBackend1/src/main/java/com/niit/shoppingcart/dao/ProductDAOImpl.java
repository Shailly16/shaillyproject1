package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
//import com.niit.shoppingcart.model.Product1;
import com.niit.shoppingcart.model.Product;



@Repository
public class ProductDAOImpl implements ProductDAO {
	
  Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	//Logger log = LoggerFactory.getLogger("com.niit.shopingcart.daoimpl.productDAOImpl");
  
 
	@Autowired
	private SessionFactory sessionFactory;
	
		
	


	public ProductDAOImpl(SessionFactory sessionFactory) {
		
			
				this.sessionFactory = sessionFactory;
				}

	
	@Transactional
	public List<Product> list() {
		log.debug("Starting of the method list");
		String hql = "from Product";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        log.debug("Ending of the method list");
	   return query.list();
	}

	@Transactional
	public boolean save(Product product1) {
		log.debug("Starting of the method : save ");
		try {
			sessionFactory.getCurrentSession().save(product1);
			log.debug("Ending of the method : save ");
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	@Transactional
	public boolean update(Product product1) {
		log.debug("Starting of the method : save ");
		try {
			sessionFactory.getCurrentSession().update(product1);
			log.debug("Ending of the method : save ");
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@Transactional
	public void saveOrUpdate(Product product1) {
		log.debug("Starting of the method : saveOrUpdate ");
		sessionFactory.getCurrentSession().save(product1);
			log.debug("Ending of the method : saveOrUpdate ");
		} 
	
	
	@Transactional
	public boolean delete(String id) {
		log.debug("Starting of the method : delete ");
		try {
			Product product1 = new Product();
			product1.setId(id);
			sessionFactory.getCurrentSession().delete(product1);
			log.debug("Ending of the method : delete ");
		} catch (HibernateException e) {
			log.error("Not able to delete the record:" + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public Product get(String id) {
		log.debug("Starting of the method : get ");
		String hql = "from Product where id=" + "'"+ id+"'";
		System.out.println(hql);
		return (Product)sessionFactory.getCurrentSession().get(Product.class, id);
		
		
	}
	
	@Transactional
	public Product getByName(String name) {
		log.debug("Starting of the method : getproductByName ");
		String hql = "from Product where name1=" + "'"+ name+"'";
		System.out.println(hql);
		return (Product)sessionFactory.getCurrentSession().get(Product.class, name);
		
		
	}
		
	
	
	

    @Transactional
	public Product getProductDetails() {
		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Product> list = (List<Product>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}


	


	


	

	
	
	
}










