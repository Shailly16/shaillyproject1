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

	@RequestMapping(value = "/manage_suppliers", method = RequestMethod.GET)
	public String listCategories(Model model) {
		log.debug("Starting of the method listSuppliers");
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("isAdminClickedSuppliers", "true");
		log.debug("End of the method listSuppliers");
		return "/home";
	}

	@RequestMapping(value = "/manage_supplier_add", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier, Model model) {
		log.debug("Starting of the method addSupplier");
		log.debug("id:" + supplier.getSid());
		if (supplierDAO.save(supplier) == true) {

			model.addAttribute("msg", "Successfully created the supplier");
		} else {
			supplierDAO.saveOrUpdate(supplier);
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

		return "admin/supplier";
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

}
