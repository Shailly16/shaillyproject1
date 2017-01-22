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
//import com.niit.shoppingcart.model.Product1;
import com.niit.shoppingcart.model.Supplier;



@Repository
public class SupplierDAOImpl implements SupplierDAO {
	
  Logger log = LoggerFactory.getLogger(SupplierDAOImpl.class);
	
	//Logger log = LoggerFactory.getLogger("com.niit.shopingcart.daoimpl.supplierDAOImpl");
 
  public SupplierDAOImpl()
	{
		
	}
	 
	@Autowired
	private SessionFactory sessionFactory;
	
		
	


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
	public List<Supplier> list() {
		log.debug("Starting of the method list");
		String hql = "from Supplier";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        log.debug("Ending of the method list");
	   return query.list();
	}

	@Transactional
	public boolean save(Supplier supplier1) {
		log.debug("Starting of the method : save ");
		try {
			sessionFactory.getCurrentSession().save(supplier1);
			log.debug("Ending of the method : save ");
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	@Transactional
	public boolean update(Supplier supplier1) {
		log.debug("Starting of the method : save ");
		try {
			sessionFactory.getCurrentSession().update(supplier1);
			log.debug("Ending of the method : save ");
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@Transactional
	public void saveOrUpdate(Supplier supplier1) {
		log.debug("Starting of the method : saveOrUpdate ");
		sessionFactory.getCurrentSession().save(supplier1);
			log.debug("Ending of the method : saveOrUpdate ");
		} 
	
	
	@Transactional
	public boolean delete(String id) {
		log.debug("Starting of the method : delete ");
		try {
			Supplier supplier1 = new Supplier();
			supplier1.setSid(id);
			sessionFactory.getCurrentSession().delete(supplier1);
			log.debug("Ending of the method : delete ");
		} catch (HibernateException e) {
			log.error("Not able to delete the record:" + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public Supplier get(String id) {
		log.debug("Starting of the method : get ");
		String hql = "from supplier where id=" + "'"+ id+"'";
		System.out.println(hql);
		return (Supplier)sessionFactory.getCurrentSession().get(Supplier.class, id);
		
		
	}
	
	@Transactional
	public Supplier getByName(String name) {
		log.debug("Starting of the method : getsupplierByName ");
		String hql = "from supplier where name1=" + "'"+ name+"'";
		System.out.println(hql);
		return (Supplier)sessionFactory.getCurrentSession().get(Supplier.class, name);
		
		
	}
		
	
	
	


	public Supplier getSupplierDetails() {
		String hql = "from supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Supplier> list = (List<Supplier>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}


	

	
	
	
}










