package com.niit.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.CategoryDAO;
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

	Gson gson=new Gson();
	
	@Autowired
	User user;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private ProductDAO productdao;

	
	
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
	
	@RequestMapping("/contact")
	public ModelAndView Contactus()
	{
		ModelAndView m=new ModelAndView("/contact");
		
	return m;
	}
	
	@RequestMapping("/hello")
	public ModelAndView login() {
		log.debug("Starting of the method hello");
		System.out.println("loginhello");
		ModelAndView mv = new ModelAndView("/hello");
		
		log.debug("Ending of the method loginHere");
		return mv;
	}
	
	/*@RequestMapping("/viewPage")
	public ModelAndView list(Model model)
	{
		List<Product> retrive=productDAO.list();
		Gson gson=new Gson();
		
		String json=gson.toJson(retrive);
		ModelAndView mv=new ModelAndView("viewPage");
		 mv.addObject("products", json);
		 System.out.println("json object is "+json);
		 for(Product p:productdao.list())
		 {
			 System.out.println("product id is " +p.getId());
		 System.out.println("product name is "+p.getName());
		 }
	        return mv;
	
	
	
}*/
	
	@RequestMapping
	public ModelAndView list(Model model)
	{
		
	     log.debug("starting of the list");
		ModelAndView mv = new ModelAndView("/viewPage");
		model.addAttribute("productList",productdao.list());
		return mv;
	}
	
	
}	
	

	
	
	



		