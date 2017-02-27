package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ContactDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Contact;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Controller
public class HomeController {

	Logger log=LoggerFactory.getLogger(HomeController.class);

	@Autowired
	User user;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;

	/**
	 * Category list will load and set to session
	 * 
	 * @param session
	 * @return
	 */
    //http://localhost:8080/ShoppingCartFrontEnd/
	
	@RequestMapping("/")
	public ModelAndView onLoad(HttpSession session) {
		log.debug("Starting of the method onLoad");
		ModelAndView mv = new ModelAndView("/home");
		session.setAttribute("category",category);
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);
		
		
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("productList", productDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());

		log.debug("Ending of the method onLoad");
		return mv;
	}


	

	@RequestMapping("/login1")
	public ModelAndView loginHere() {
		log.debug("Starting of the method loginHere");
		System.out.println("loginHere");
		ModelAndView mv = new ModelAndView("/login1");
		mv.addObject("user",user);
		mv.addObject("isUserClickedLoginHere", "true");
		log.debug("Ending of the method loginHere");
		return mv;
	}

	
	@RequestMapping("/home")
	public String reDirectToHome(@ModelAttribute("selectedProduct") final Product selectedProduct, final Model model) {
		log.debug("Starting of the method reDirectToHome");
		model.addAttribute("selectedProduct", selectedProduct);
	    model.addAttribute("categoryList", this.categoryDAO.list());
	    model.addAttribute("productList", this.productDAO.list());
		log.debug("Ending of the method reDirectToHome");
		return "/home";
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contactPage() {
		
		
		return new ModelAndView("contact");
	}

	@ModelAttribute("contact")
	public Contact contact()
	{
		return new Contact();
	}
	@RequestMapping("/addContact")
	public String addContact(@ModelAttribute("contact") Contact contact , BindingResult result)
	{
		
	
		return "contact";
		
	}
}
	
	
	



		