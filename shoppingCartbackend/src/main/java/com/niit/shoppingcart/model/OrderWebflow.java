package com.niit.shoppingcart.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderWebflow {
	
	private static Logger log =LoggerFactory.getLogger(OrderWebflow.class);
	
	@Autowired
	Order order;
	public Order initFlow(){
		log.debug("Starting of initflow");
		order = new Order();
		log.debug("End of initflow");
		return order;
	}
	
	

}
