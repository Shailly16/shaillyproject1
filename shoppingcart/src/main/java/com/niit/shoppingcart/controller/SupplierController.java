package com.niit.shoppingcart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SupplierController {

	private static Logger log = LoggerFactory.getLogger(SupplierController.class);
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;
	
	@RequestMapping(value="/manage_suppliers", method = RequestMethod.GET)
	public String listCategories(Model model){
		log.debug("Starting of the method listCategories");
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("isAdminClickedCategories", "true");
		log.debug("End of the method listCategories");
		return "/home";
	}
	
	@RequestMapping(value="/manage_suppliers", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute ("supplier") Supplier supplier,Model model){
		log.debug("Starting of the method addSupplier");
		log.debug("id:"+ supplier.getSid());
		if (supplierDAO.save(supplier)==true){
		
		model.addAttribute("msg", "Successfully created/updated the supplier");}
		else
		{
			model.addAttribute("msg", "not able to create/update the supplier");}
		
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("isAdminClickedCategories", "true");
		log.debug("End of the method addSupplier");
		return "/home";
	}
	
	@RequestMapping(value="/manage_supplier_remove/{id}")
	public String deleteSupplier(@PathVariable("id")String id, Model model) throws Exception
	{
		boolean flag = supplierDAO.delete(id);
		
		String msg = "Successfully done the operation";
		if(flag!= true)
		{
			msg = "The operation could not success";
			
		}
		model.addAttribute("msg", msg);
		
		return"forward:/manage_suppliers";
	}
		
	@RequestMapping(value="/manage_supplier_edit/{id}")
	public String editSupplier(@PathVariable("id")String id, Model model) throws Exception
	{
		log.debug("Starting of the method editSupplier");
		supplier = supplierDAO.get(id);
		
		model.addAttribute("supplier",supplier);
		
		return"forward:/manage_suppliers";
	}
		
	
		
		
	}
	
	
			

