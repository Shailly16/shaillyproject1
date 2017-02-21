package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
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
		log.debug("Starting of the method : update ");
		Session s= sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		Supplier sd= (Supplier)s.get(Supplier.class, supplier1.getSid());
		sd.setSid(supplier1.getSid());
		sd.setName(supplier1.getName());
		sd.setAddress(supplier1.getAddress());
		s.saveOrUpdate(sd);
		s.flush();
		t.commit();
		return true;
	}
	
	@Transactional
	public void saveOrUpdate(Supplier supplier1) {
		log.debug("Starting of the method : saveOrUpdate ");
		sessionFactory.getCurrentSession().save(supplier1);
	    log.debug("Ending of the method : saveOrUpdate ");
		} 
	
	
	@Transactional
	public void delete(String id) {
		log.debug("Starting of the method : delete ");
		
		Session s= sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		Supplier sd= (Supplier)s.get(Supplier.class, id);
		s.delete(sd);
		s.flush();
		t.commit();
			log.debug("Ending of the method : delete ");
		
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
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Supplier.class);
		criteria.add(Restrictions.like("name", name));
		return(Supplier)criteria.uniqueResult();
		
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










