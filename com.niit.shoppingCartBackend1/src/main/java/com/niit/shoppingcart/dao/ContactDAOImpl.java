package com.niit.shoppingcart.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Contact;
	
	
@Repository
public class ContactDAOImpl implements ContactDAO{

static Logger log = LoggerFactory.getLogger(ContactDAOImpl.class);


private SessionFactory sessionFactory;
			
				
			

			@Autowired
			public ContactDAOImpl(SessionFactory sessionFactory) {
				
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
		public boolean contactUs(Contact contact) {
			log.debug("Starting of the method : save ");
			try {
				sessionFactory.getCurrentSession().save(contact);
				log.debug("Ending of the method : save ");
			} catch (HibernateException e) {
				
				e.printStackTrace();
				return false;
			}
			
			return true;
			 
		}
		
	}


