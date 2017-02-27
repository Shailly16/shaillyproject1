package com.niit.shoppingcart.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SupplierController {

	private static Logger log = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	@RequestMapping(value = "/manage_suppliers", method = RequestMethod.GET)
	public String listCategories(Model model) {
		log.debug("Starting of the method listSuppliers");
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("isAdminClickedSuppliers", "true");
		log.debug("End of the method listSuppliers");
		return "/home";
	}

	@RequestMapping(value = "/manage_supplier_add/{id}", method = RequestMethod.POST)
	public String addSupplier(@PathVariable("id") String id, Supplier supplier, Model model) {
		log.debug("Starting of the method addSupplier");
		log.debug("id:" + supplier.getSid());
		if (supplier.getSid().equals(supplierDAO.get(id))) {
			
			supplierDAO.update(supplier);
			model.addAttribute("msg", "Successfully created the supplier");
		} else {
			supplierDAO.save(supplier);
			model.addAttribute("msg", "updated the supplier");
		}

		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("isAdminClickedSuppliers", "true");
		log.debug("End of the method addSupplier");
		return "redirect:/manageSuppliers";
	}

	@RequestMapping(value = "/manage_supplier_remove/{id}")
	public String deleteSupplier(@PathVariable("id") String id, Model model) throws Exception {
		System.out.println("supplier id is" + id);
		try {
			supplierDAO.delete(id);
			model.addAttribute("message", "Successfully removed");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/manageSuppliers";
	}

	@RequestMapping(value = "/manage_supplier_edit/{id}")
	public String editSupplier(@PathVariable("id") String id, Model model) throws Exception {
		log.debug("Starting of the method editSupplier");
		supplier = supplierDAO.get(id);
		
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("isAdminClickedSuppliers", "true");
		return "admin/supplier";
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

