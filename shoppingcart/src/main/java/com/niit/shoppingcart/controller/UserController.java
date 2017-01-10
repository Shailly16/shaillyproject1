package com.niit.shoppingcart.controller;

import java.util.List;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.MyCart;
import com.niit.shoppingcart.model.Category1;
import com.niit.shoppingcart.model.Supplier1;
import com.niit.shoppingcart.model.User1;

@Controller
public class UserController {

	public static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDAO userDAO;

	@Autowired
	User1 user;

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private MyCart myCart;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category1 category;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier1 supplier;

	
	@Autowired
	private HttpSession session;

	/**
	 * if invalid credentials -> Home page , login , error message if valid
	 * credentials && he is admin -> AdminHome page ,logout link if valid
	 * credentials && he is end user -> Home page, myCart, logout link
	 * 
	 * @param userID
	 * @param password
	 * @return it will return data and page name where to return
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView validate(@RequestParam(value = "username") String userID,
			@RequestParam(value = "password") String password) {
		log.debug("Starting of the method validate");

		// ModelAndView mv = new ModelAndView("/home");
		ModelAndView mv = new ModelAndView("/home");
		user = userDAO.validate(userID, password);
		// if the record exist with this userID and password it will return user
		// details else will return null

		if (user != null) {
			log.debug("Valid Credentials");
			// null means invalid credentials
			session.setAttribute("loggedInUser", user.getName());
			session.setAttribute("loggedInUserID", user.getId());

			session.setAttribute("user", user); //

			if (user.getRole().equals("ROLE_ADMIN")) {
				log.debug("Logged in as Admin");
				mv.addObject("isAdmin", "true");
				session.setAttribute("supplier", supplier);
				session.setAttribute("supplierList", supplierDAO.list());
                                                                 session.setAttribute("productList", categoryDAO.list());
                                                                 session.setAttribute("product", product);
				session.setAttribute("categoryList", categoryDAO.list());

			} else {
				log.debug("Logged in as User");
				mv.addObject("isAdmin", "false");
				//myCart = cartDAO.list(userID);
				mv.addObject("myCart", myCart);
				// Fetch the myCart list based on user ID
				List<MyCart> cartList = cartDAO.list(userID);
				mv.addObject("cartList", cartList);
				mv.addObject("cartSize", cartList.size());
			}

		} else {
			log.debug("Invalid Credentials");

			mv.addObject("invalidCredentials", "true");
			mv.addObject("errorMessage", "Invalid Credentials");

		}
		log.debug("Ending of the method validate");
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		log.debug("Starting of the method logout");
		ModelAndView mv = new ModelAndView("/home");
		session.invalidate(); // will remove the attributes which are added
								// session
		session = request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());

		mv.addObject("logoutMessage", "You successfully logged out");
		mv.addObject("loggedOut", "true");
		
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
		  //  return "redirect:/login?logout";
		    
		    
		log.debug("Ending of the method logout");
		return mv;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute User1 user) {
		log.debug("Starting of the method registerUser");
		ModelAndView mv = new ModelAndView("home");
		if (userDAO.get(user.getId()) == null) {
			user.setRole("ROLE_USER"); // all the users are end users by default
			userDAO.update(user);
			log.debug("You are successfully register");
			mv.addObject("successMessage", "You are successfully registered");
		} else {
			log.debug("User exist with this id");
			mv.addObject("errorMessage", "User exist with this id");
		}
		log.debug("Ending of the method registerUser");
		return mv;
	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(Model model) {
		log.debug("Starting of the method loginError");
		model.addAttribute("errorMessage", "Login Error");
		log.debug("Ending of the method loginError");
		return "home";

	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		log.debug("Starting of the method accessDenied");
		model.addAttribute("errorMessage", "You are not authorized to access this page");
		log.debug("Ending of the method accessDenied");
		return "home";

	}

}