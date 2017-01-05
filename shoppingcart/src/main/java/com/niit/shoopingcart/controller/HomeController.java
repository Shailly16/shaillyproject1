package com.niit.shoopingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User1;

@Controller
public class HomeController {
	@Autowired
	UserDAO userDAO;
	@Autowired
	User1 user;

	@RequestMapping("/home")
	public String homePage() {
		System.out.println("Execute");
		return "home";
	}

	@RequestMapping("/login1")
	public ModelAndView showLoginPage() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("msg", "This is login page");
		mv.addObject("showLoginPage", "true");
		return mv;
	}

	@RequestMapping("/Registeration")
	public ModelAndView showRegisterPage() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("msg", "This is registeration page");
		mv.addObject("showRegisterPage", "true");
		return mv;
	}

	@RequestMapping("/validate")
	public ModelAndView validate(@RequestParam("id") String id, @RequestParam("password") String pwd) {
		System.out.println("In validate Method");
		System.out.println("Id" + id);
		System.out.println("password" + pwd);

		ModelAndView mv = new ModelAndView("home");
		// need to validate-need to write DAO-get value from tables
		// Temporarily id:niit and password:niit@123
		// if credentials are valid- "welcome to shopping cart"
		// else show"invalid credentials"+ login Page
		// both displayed on home page

		if (userDAO.validate(id, pwd)) {
			mv.addObject("successMsg", "You logged in successfully");
		} else {
			mv.addObject("errorMsg", "You logged in unsuccessfully");
		}

		return mv;
	}

}
