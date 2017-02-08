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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.ProductDAOImpl;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.util.FileUtil;
import com.niit.shoppingcart.util.Util;
@Controller
public class ProductController {
	
private static Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private SupplierDAO supplierDAO;

	private String path;
	
	
	@RequestMapping(value="/manage_products", method = RequestMethod.GET)
	public String listProducts(Model model){
		log.debug("Starting of the method listProducts");
		model.addAttribute("product", new Product());
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("isAdminClickedProducts", "true");
		log.debug("End of the method listProducts");
		return "/home";

}
	
	@RequestMapping(value="/manage_product_add")
	public String addProduct(@ModelAttribute ("product") Product product, @RequestParam("image") MultipartFile file,Model model)
	{
	log.debug("Starting of the method addProduct");
	/*Category category = categoryDAO.getByName(product.getCategory().getName());
	
	Supplier supplier = supplierDAO.getByName(product.getSupplier().getName());
	
	product.setCategory(category);
	product.setSupplier(supplier);
	
	product.setCategory_id(category.getCid());
	product.setSupplier_id(supplier.getSid());
	product.setId(com.niit.shoppingcart.util.Util.removeComman(product.getId()));*/
	log.debug("id:"+ product.getId());
	if (productDAO.save(product) == true){
	
	model.addAttribute("msg", "Successfully created/updated the product");}
	else
	{
	model.addAttribute("msg", "not able to create/update the product");}
	
	
	
	
	FileUtil.upload(path,file,product.getId()+".jpg");
	
	model.addAttribute("productList", this.productDAO.list());
	model.addAttribute("product", new Product());
	model.addAttribute("isAdminClickedProducts", "true");
	log.debug("End of the method addProduct");
	return "/home";
	}
	
	@RequestMapping(value="/manage_product_remove/{id}")
	public String deleteProduct(@PathVariable("id")String id, ModelMap model) throws Exception
	{
		log.debug("Starting of the method removeProduct");
		
		try {
			productDAO.delete(id);
			model.addAttribute("message", "Successfully removed");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}

		return"forward:/manageProducts";
	}
		
	@RequestMapping(value="manage_product_edit/{id}")
	public String editProduct(@PathVariable("id")String id, Model model) throws Exception
	{
		log.debug("Starting of the method editProduct");
		product = productDAO.get(id);
		
		model.addAttribute("selectedproduct", product);
		log.debug("End of the method edit Product");
		return "forward:/manage_products";
	}
	
	@RequestMapping(value="manage_product/get/{id}")
	public ModelAndView getSelectedProduct(@PathVariable("id")String id, RedirectAttributes redirectAttribute) throws Exception
	{
		log.debug("Starting of the method getselectedProduct");
		product = productDAO.get(id);
		
		ModelAndView mv = new ModelAndView("redirect:/home");
		redirectAttribute.addFlashAttribute("selectedProduct", productDAO.get(id));
		log.debug("Ending of the method getselectedProduct");
		return mv;
	}
		
}


	
	
	
	