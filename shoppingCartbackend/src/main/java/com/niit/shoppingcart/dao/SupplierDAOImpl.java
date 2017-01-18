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

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Product1;
import com.niit.shoppingcart.model.Supplier1;



@Repository
public class SupplierDAOImpl implements SupplierDAO {
	
  Logger log = LoggerFactory.getLogger("SupplierDAOImpl.class");
	
	//Logger log = LoggerFactory.getLogger("com.niit.shopingcart.daoimpl.SupplierDAOImpl");
  
	 
	@Autowired
	private SessionFactory sessionFactory;
	
		
	public SupplierDAOImpl()
	{
		
	}


	public SupplierDAOImpl(SessionFactory sessionFactory) {
		
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
	public List<Supplier1> list() {
		log.debug("Starting of the method list");
		String hql = "from Supplier1";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        log.debug("Ending of the method list");
	   return query.list();
	}

	@Transactional
	public boolean save(Supplier1 supplier) {
		log.debug("Starting of the method : save ");
		try {
			sessionFactory.getCurrentSession().save(supplier);
			log.debug("Ending of the method : save ");
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	@Transactional
	public boolean update(Supplier1 supplier) {
		log.debug("Starting of the method : save ");
		try {
			sessionFactory.getCurrentSession().update(supplier);
			log.debug("Ending of the method : save ");
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@Transactional
	public void saveOrUpdate(Supplier1 supplier) {
		log.debug("Starting of the method : saveOrUpdate ");
		sessionFactory.getCurrentSession().save(supplier);
			log.debug("Ending of the method : saveOrUpdate ");
		} 
	
	
	@Transactional
	public boolean delete(String id) {
		log.debug("Starting of the method : delete ");
		try {
			Supplier1 supplier = new Supplier1();
			supplier.setId(id);
			sessionFactory.getCurrentSession().delete(supplier);
			log.debug("Ending of the method : delete ");
		} catch (HibernateException e) {
			log.error("Not able to delete the record:" + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public Supplier1 get(String id) {
		log.debug("Starting of the method : get ");
		String hql = "from Supplier1 where id=" + "'"+ id+"'";
		System.out.println(hql);
		return (Supplier1)sessionFactory.getCurrentSession().get(Supplier1.class, id);
		
		
	}
	
	@Transactional
	public Supplier1 getByName(String name) {
		log.debug("Starting of the method : getSupplierByName ");
		String hql = "from Supplier1 where name1=" + "'"+ name+"'";
		System.out.println(hql);
		return (Supplier1)sessionFactory.getCurrentSession().get(Supplier1.class, name);
		
		
	}
		
	
	
	public Supplier1 getSupplierDetails()
	{
		String hql = "from Supplier1";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Supplier1> list = (List<Supplier1>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
		
	}


	
	
	
}










