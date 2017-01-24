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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
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
	
	
	@RequestMapping(value="/manage_products", method = RequestMethod.GET)
	public String listProducts(Model model){
		log.debug("Starting of the method listProducts");
		model.addAttribute("product",  product);
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("isAdminClickedProducts", "true");
		log.debug("End of the method listProducts");
		return "/home";

}
	
	@RequestMapping(value="manage_product_add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute ("product") Product product, @RequestParam("image") MultipartFile file,Model model)
	{
	log.debug("Starting of the method listProducts");
	Category category = categoryDAO.getByName(product.getCategory().getName());
	
	Supplier supplier = supplierDAO.getByName(product.getSupplier().getName());
	
	product.setCategory(category);
	product.setSupplier(supplier);
	
	product.setCategory_id(product.getId());
	product.setSupplier_id(supplier.getSid());
	product.setId(com.niit.shoppingcart.util.Util.removeComman(product.getId()));
	productDAO.save(product);
	//FileUtil.upload(path,file,product.getId()+".jpg");
	log.debug("End of the method listProducts");
	
	model.addAttribute("isAdminClickedProducts", "true");
	model.addAttribute("productList", this.productDAO.list());
	model.addAttribute("product", new Product());
	return "/home";
	}
	
	@RequestMapping(value="manage_product_remove/{id}")
	public String deleteProduct(@PathVariable("id")String id, Model model) throws Exception
	{
		boolean flag = productDAO.delete(id);
		
		String msg = "Successfully done the operation";
		if(flag!= true)
		{
			msg = "The operation could not success";
			
		}
		model.addAttribute("msg", msg);
		
		return"forward:/manage_products";
	}
		
	@RequestMapping(value="manage_product_edit/{id}")
	public String editProduct(@PathVariable("id")String id, Model model) throws Exception
	{
		log.debug("Starting of the method editCategory");
		product = productDAO.get(id);
		
		model.addAttribute("product",new Product());
		
		return"forward:/manage_products";
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


	
	
	
	