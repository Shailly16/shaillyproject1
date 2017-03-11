package com.niit.shoppingcart.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
/*import com.niit.shoppingcart.model.MyCart;*/
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Address;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Contact;
import com.niit.shoppingcart.model.Item;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Controller
public class UserController {

	public static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDAO userDAO;

	@Autowired
	User user1;

	

	/*@Autowired
	private MyCart myCart;
*/
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	
	private Address address;
	@Autowired
	private HttpSession session;
	
	@Autowired
	private Product product;

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
			@RequestParam(value = "password") String password, HttpSession session ) {
		log.debug("Starting of the method validate");

		// ModelAndView mv = new ModelAndView("/home");
		ModelAndView mv = new ModelAndView("/home");
		user1 = userDAO.validate(userID, password);
		// if the record exist with this userID and password it will return user
		// details else will return null

		if (user1 != null) {
			log.debug("Valid Credentials");
			// null means invalid credentials
			user1 = userDAO.get(userID);
			session.setAttribute("loggedInUser", user1.getName());
			session.setAttribute("loggedInUserID", user1.getId());

			session.setAttribute("user", user1); //

			if (user1.getRole().equals("ROLE_ADMIN")) {
				log.debug("Logged in as Admin");
				mv.addObject("isAdmin", "true");
			
				session.setAttribute("supplier", supplier);
				session.setAttribute("supplierList", supplierDAO.list());
                
                session.setAttribute("category",category);
				session.setAttribute("categoryList", categoryDAO.list());

			} else {
				log.debug("Logged in as User");
				mv.addObject("isAdmin", "false"); 
				/*//myCart = cartDAO.list(userID);
				mv.addObject("myCart", myCart);
				// Fetch the myCart list based on user ID
				List<Cart> cartList = cartDAO.list(password);
				mv.addObject("cartList", cartList);
				mv.addObject("cartSize", cartList.size());*/
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

	@RequestMapping("/register")
	public ModelAndView registerHere() {
		log.debug("Starting of the method registerHere");
		ModelAndView mv = new ModelAndView("/register");
		mv.addObject("user", new User());
		mv.addObject("isUserClickedRegisterHere", "true");
		log.debug("Ending of the method registerHere");
		return mv;
	}
	@RequestMapping(value = "/registeration", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute User user1) {
		log.debug("Starting of the method registerUser");
		ModelAndView mv = new ModelAndView("/home");
		if (userDAO.get(user1.getId()) == null) {
			user1.setRole("ROLE_USER"); // all the users are end users by default
			userDAO.saveOrUpdate(user1);
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
		return "/home";

	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		log.debug("Starting of the method accessDenied");
		model.addAttribute("errorMessage", "You are not authorized to access this page");
		log.debug("Ending of the method accessDenied");
		return "/home";

	}
	public Product initFlow(){
		System.out.println("inside initflow");
		return product;
	}
	List<Item> cart = null;
	
	/*@RequestMapping("/cart")
	 public String Order() {
		System.out.println("inside order");
     return "cart";
	}*/
     
     
	 public String insertAddress( Address address , MessageContext messageContext) {
	 System.out.println("user controller insert address");
	 this.address=address;
	 	String str= userDAO.insertAddress(address);
	 	return str;
}
	 public Address getadd()
	 {
	 	return address;
	 }
	
	 @RequestMapping(value = "/addcontact" , method = RequestMethod.POST)
		public String saveEmployee(@ModelAttribute("contact")Contact c,ModelMap map )
		   {
		userDAO.addContact(c);
		  
		  return "home";
		 }
	 
	 private String getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
	    }


}

	
