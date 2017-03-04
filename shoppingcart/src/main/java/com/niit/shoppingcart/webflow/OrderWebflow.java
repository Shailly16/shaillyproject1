package com.niit.shoppingcart.webflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shoppingcart.model.BillingAddress;
import com.niit.shoppingcart.model.Order;
import com.niit.shoppingcart.model.PaymentMethod;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.ShippingAddress;

@Component
public class OrderWebflow {
	
	private static Logger log =LoggerFactory.getLogger(OrderWebflow.class);
	
	@Autowired
	Order order;
	@Autowired
	Product product;
	
	
	public Product initFlow(){
		System.out.println("init flow");
		return product;
	}
	
	
	@RequestMapping("/user/shippingAddress")
	 public String Order() {
		System.out.println("inside order method");
         return "redirect:/cart_checkout";
	}
	
	/*public Order initFlow(){
		log.debug("Starting of initflow");
		order = new Order();
		log.debug("End of initflow");
		return order;
	}*/
	public String addShippingAddress(Order order,ShippingAddress shippingAddress){
		log.debug("Starting of addShippingAddress");
		order.setShippingAddress(shippingAddress);
		log.debug("End of addShippingAddress");
		return "success";
	}
	public String addBillingAddress(Order order,BillingAddress billingAddress){
		log.debug("Starting of addBillingAddress");
		order.setBillingAddress(billingAddress);
		log.debug("End of addBillingAddress");
		return "success";
	}
	
	public String addPaymentMethod(Order order,PaymentMethod paymentMethod){
		log.debug("Starting of addPaymentMethod");
		order.setPaymentMethod(paymentMethod.getPaymentMethod());
		confirmOrder(order);
		log.debug("End of addPaymentMethod");
		return "success";
	}
	public String confirmOrder(Order order) 
	{ log.debug("Starting of confirmOrder");
	
	log.debug("End of confirmOrder");
	return "success";
	}
	
	
	

}
