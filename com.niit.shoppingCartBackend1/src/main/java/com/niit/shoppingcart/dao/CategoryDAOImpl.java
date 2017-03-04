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

import com.niit.shoppingcart.dao.CategoryDAO;
//import com.niit.shoppingcart.model.Product1;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Category;
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
		log.debug("Starting of the method : update ");
		Session s= sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		Category sd= (Category)s.get(Category.class, category1.getCid());
		sd.setCid(category1.getCid());
		sd.setName(category1.getName());
		sd.setDescription(category1.getDescription());
		s.saveOrUpdate(sd);
		s.flush();
		t.commit();
		
		return true;
	}
	
	@Transactional
	public boolean saveOrUpdate(Category category1) {
		log.debug("Starting of the method : saveOrUpdate ");
		try {
			sessionFactory.getCurrentSession().save(category1);
			log.debug("Ending of the method : saveOrUpdate ");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
			return true;
			
		} 
	
	
	@Transactional
	public void delete(String id) {
		
		Session s= sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		Category sd= (Category)s.get(Category.class, id);
		s.delete(sd);
		s.flush();
		t.commit();
	    log.debug("Ending of the method : delete ");
		 
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
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
		criteria.add(Restrictions.like("name", name));
		return(Category)criteria.uniqueResult();
		
		
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










