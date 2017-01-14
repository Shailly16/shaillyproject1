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

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category1;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
  Logger log = LoggerFactory.getLogger("CategoryDAOImpl.class");
	
	//Logger log = LoggerFactory.getLogger("com.niit.shopingcart.dao.CategoryDAOImpl");
  
	 
	@Autowired
	private SessionFactory sessionFactory;
	
		
	public CategoryDAOImpl()
	{
		
	}


	public CategoryDAOImpl(SessionFactory sessionFactory) {
		
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
	public List<Category1> list() {
		String hql = "from Category1";
        Query query =	sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
	}
	
	@Transactional
	public void saveOrUpdate(Category1 category) {
		log.debug("Starting of the method : saveOrUpdate ");
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		log.debug("Ending of the method : saveOrUpdate ");
	}
	

	@Transactional
	public boolean save(Category1 category) {
		log.debug("Starting of the method : save ");
		try {
			sessionFactory.getCurrentSession().save(category);
			log.debug("Ending of the method : save ");
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	@Transactional
	public boolean update(Category1 category) {
		log.debug("Starting of the method : save ");
		try {
			sessionFactory.getCurrentSession().update(category);
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
			Category1 category = new Category1();
			category.setId(id);
			sessionFactory.getCurrentSession().delete(category);
			log.debug("Ending of the method : delete ");
		} catch (HibernateException e) {
			log.error("Not able to delete the record:" + e.getMessage());
			e.printStackTrace();
		}
	}

	@Transactional
	public Category1 get(String id) {
		log.debug("Starting of the method : get ");
		String hql = "from Category1 where id=" + "'"+ id+"'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("hql"+hql);
		@SuppressWarnings("unchecked")
		List<Category1> list = (List<Category1>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		log.debug("end get");
		return null;
		
	}
	
	
	
	
	
		
		
	}


	
	
	












	
	 
    
