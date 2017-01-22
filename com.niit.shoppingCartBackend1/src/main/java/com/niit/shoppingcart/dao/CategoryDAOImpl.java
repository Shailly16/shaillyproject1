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
//import com.niit.shoppingcart.model.Product1;
import com.niit.shoppingcart.model.Category;



@Repository(value="categoryDAOImpl")
public class CategoryDAOImpl implements CategoryDAO {
	
  Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);
	
	//Logger log = LoggerFactory.getLogger("com.niit.shopingcart.daoimpl.categoryDAOImpl");
  
  
	
	private SessionFactory sessionFactory;
	
		
	

	@Autowired
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
	public List<Category> list() {
		log.debug("Starting of the method list");
		String hql = "from Category";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        log.debug("Ending of the method list");
	   return query.list();
	}

	@Transactional
	public boolean save(Category category1) {
		log.debug("Starting of the method : save ");
		try {
			sessionFactory.getCurrentSession().save(category1);
			log.debug("Ending of the method : save ");
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	@Transactional
	public boolean update(Category category1) {
		log.debug("Starting of the method : save ");
		try {
			sessionFactory.getCurrentSession().update(category1);
			log.debug("Ending of the method : save ");
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@Transactional
	public void saveOrUpdate(Category category1) {
		log.debug("Starting of the method : saveOrUpdate ");
		sessionFactory.getCurrentSession().save(category1);
			log.debug("Ending of the method : saveOrUpdate ");
		} 
	
	
	@Transactional
	public boolean delete(String id) {
		log.debug("Starting of the method : delete ");
		try {
			Category category1 = new Category();
			category1.setCid(id);
			sessionFactory.getCurrentSession().delete(category1);
			log.debug("Ending of the method : delete ");
		} catch (HibernateException e) {
			log.error("Not able to delete the record:" + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public Category get(String id) {
		log.debug("Starting of the method : get ");
		String hql = "from category where id=" + "'"+ id+"'";
		System.out.println(hql);
		return (Category)sessionFactory.getCurrentSession().get(Category.class, id);
		
		
	}
	
	@Transactional
	public Category getByName(String name) {
		log.debug("Starting of the method : getcategoryByName ");
		String hql = "from category where name1=" + "'"+ name+"'";
		System.out.println(hql);
		return (Category)sessionFactory.getCurrentSession().get(Category.class, name);
		
		
	}
		
	
	
	

    @Transactional
	public Category getCategoryDetails() {
		String hql = "from category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> list = (List<Category>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}


	


	

	
	
	
}










