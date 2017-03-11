package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Product;

@Controller
	public class CartController {
		private static Logger log = LoggerFactory.getLogger(CartController.class);
		@Autowired
		private CartDAO cartDAO;
		
		
		private Cart myCart;
		
		@Autowired
		private ProductDAO productDAO;
		@Autowired
		private Product product;
		
		@RequestMapping(value="/myCart", method = RequestMethod.GET)
		public String myCart(Model model,HttpSession session)
		{
			log.debug("Starting of the method myCart");
			model.addAttribute("myCart", new Cart());
			String loggedInUserid = (String) session.getAttribute("loggedInUserID");
			
			if(loggedInUserid == null){
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				loggedInUserid = auth.getName();
				
			}
			
			
			
			int cartSize = cartDAO.list(loggedInUserid).size();
			
			if(cartSize == 0){
			    model.addAttribute("errorMessage", "You do not have products in the Cart");}
				else{
				model.addAttribute("myCart", cartDAO.list(loggedInUserid));
				model.addAttribute("totalAmount", cartDAO.getTotalAmount(loggedInUserid));
				model.addAttribute("displayCart", "true");
			}
				
			    log.debug("End of the method myCart");
			    return "/home";
		
		}

}

		
      /*  @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
          public ModelAndView addToCart(@PathVariable("id")String id, HttpSession session, Model model) {
	      log.debug("Starting of the method addToCart");
	      Product product= productDAO.get(id);
	      myCart.setPid(product.getId());
	      myCart.setPrice(product.getPrice());
	      myCart.setProductName(product.getName());
	      String loggedInUserid = (String) session.getAttribute("loggedInUserID");
	      model.addAttribute("myCart", cartDAO.list(loggedInUserid));
	      model.addAttribute("displayCart", "true");
			if(loggedInUserid == null){
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				loggedInUserid = auth.getName();
				
			}
			myCart.setUserID(loggedInUserid);
			
	        myCart.setStatus('N');
	      
	        
		 cartDAO.save(myCart);
			
			ModelAndView mv = new ModelAndView("/user/cart");
			mv.addObject("successMessage", "Successfully added the product to myCart");
			log.debug("Ending of the method addToCart");
			return mv;
			
	
		
       }*/
          
          
		