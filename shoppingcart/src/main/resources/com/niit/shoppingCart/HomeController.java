package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controllers
public class HomeController
{
	@RequestMapping("/home")
	public ModelAndView homePage()
	{
		System.out.println("Execute");
		return home;
	}
	@RequestMapping("/login1")
	public ModelAndView showSLoginPage()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("msg", "This is login page");;
		mv.addObject("msg", "This is login page");
		return mv;
	}
	@RequestMapping("/register")
	public ModelAndView showRegisterationPage()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("msg", "This is registerstion page");
		mv.addObject("showRegisterationPage", "true");
		return mv;
	}
	@RequestMapping(/"validate")
	public ModelAndView validate(@RequestParam("id")String id,@RequestParam("password")String pwd)
	{
		System.out.println("sIn validate Method");
		System.out.println("Id"+id);
		System.out.println("password"+pwd);
		ModelAndView mv=new ModelAndView("home");
		// need to validate-need to write DAO-get value from tables
		// temporaraly id:niit and password:niit@123
		// if credentials are valid- "welcome to shopping cart"
		// else show"invalid credentials"+ login Page
		// both displayed on home page
		UserDao userDao=new UserDAO();
		if (userDAO.isValidCredentials(id,pwd)== true)
		{mv.addObject("successMsg", "You logged in successfully");)
		}
		else
		{mv.addObject("errorMsg", "You logged in unsuccessfully");
		}
		}
		return mv;
	}
	
}
 
