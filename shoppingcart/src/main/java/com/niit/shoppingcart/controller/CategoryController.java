package com.niit.shoppingcart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller
public class CategoryController {

	private static Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@RequestMapping(value="/manage_categories", method = RequestMethod.GET)
	public String listCategories(Model model){
		log.debug("Starting of the method listCategories");
		model.addAttribute("category",  category);
		
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("isAdminClickedCategories", "true");
		log.debug("End of the method listCategories");
		return "/home";
		 }
	
	
	@RequestMapping(value="/manage_category_add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute ("category") Category category, Model model){
		log.debug("Starting of the method addCategory");
		log.debug("id:"+ category.getCid());
		if (categoryDAO.save(category) == true){
		
		model.addAttribute("msg", "Successfully created/updated the category");}
		else
		{
			model.addAttribute("msg", "not able to create/update the category");}
		
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("isAdminClickedCategories", "true");
		log.debug("End of the method addCategory");
		return "/manageCategories";
	}
	
	@RequestMapping(value="manage_category_remove/{id}")
	public String deleteCategory(@PathVariable("id")String cid, ModelMap model) throws Exception
	{
		log.debug("Starting of the method removeCategory");
		try {
			categoryDAO.delete(cid);
			model.addAttribute("message", "Successfully removed");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}

		return"forward:/manage_categories";
	}
		
	@RequestMapping(value="manage_category_edit/{id}")
	public String editCategory(@PathVariable("id")String id, Model model) throws Exception
	{
		log.debug("Starting of the method editCategory");
		category = categoryDAO.get(id);
		categoryDAO.update(category);
		model.addAttribute("category",category);
		
		return"forward:/manage_categories";
	}
		
	
		
		
	}
	
	
			

