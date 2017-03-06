package com.niit.shoppingcart.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
	private  Category category;

	@Autowired
	private Supplier supplier;

	@Autowired
	private SupplierDAO supplierDAO;

	private Path path;
	
	String k;

	@RequestMapping(value = "/manage_products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		log.debug("Starting of the method listProducts");
		model.addAttribute("product", new Product());
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("supplierList", this.supplierDAO.list());
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("isAdminClickedProducts", "true");
		log.debug("End of the method listProducts");
		return "admin/product";

	}

	@RequestMapping(value = "/manage_product_add")
	public String addProduct(@ModelAttribute("product") Product product, MultipartFile file,
			Model model, HttpServletRequest request) {
		
		log.debug("Starting of the method addProduct");
		log.debug("id:"+ product.getId()); 
		System.out.println("abc is" +k);
		category= categoryDAO.getByName(product.getCategory().getName());
		supplier = supplierDAO.getByName(product.getSupplier().getName());
		 
		 product.setCategory(category); 
		 product.setSupplier(supplier);
		 product.setCategory_id(category.getCid());
		 product.setSupplier_id(supplier.getSid());
		
		 /*product.setId(com.niit.shoppingcart.util.Util.removeComman(product.
		 * getId())); log.debug("id:"+ product.getId()); if
		 * (productDAO.save(product) == true){
		 * 
		 * model.addAttribute("msg",
		 * "Successfully created/updated the product");} else {
		 * model.addAttribute("msg", "not able to create/update the product");}
		 * 
		 //FileUtil.upload(path,file,product.getId()+".jpg");
		 */

		   if(product.getId()!= null)
		   {
			productDAO.save(product);}
			else
			{
				product.setId(k);
				productDAO.update(product);
	            model.addAttribute("msg", "updated the product");}
			
		
			MultipartFile image = product.getImage();
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			path = Paths.get(rootDirectory + "/resources/img/" + product.getName() + ".png");
			System.out.println(path);
			if (image != null && !image.isEmpty()) {
				try {
					image.transferTo(new File(path.toString()));
				} catch (Exception ex) {
					ex.printStackTrace();
					throw new RuntimeException("Product image saving failed", ex);
				}
			} 

		
		
		log.debug("End of the method addProduct");
		return "redirect:/manageProducts";
	}

	@RequestMapping(value = "/manage_product_remove/{id}")
	public String deleteProduct(@PathVariable("id") String id, ModelMap model) throws Exception {
		log.debug("Starting of the method removeProduct");

		try {
			productDAO.delete(id);
			model.addAttribute("message", "Successfully removed");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/manageProducts";
	}

	@RequestMapping(value = "/manage_product_edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) throws Exception {
		log.debug("Starting of the method editProduct");
		k=id;
		product = productDAO.get(id);
       
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("isAdminClickedProducts", "true");
		return "/admin/product";
	}

	
	

	@RequestMapping(value = "/display/{id}")
	public String getSelectedProduct(@PathVariable("id") String id,Model model)
			throws Exception {
		log.debug("Starting of the method getselectedProduct");
		product = productDAO.get(id);
       model.addAttribute("product", product);
		log.debug("Ending of the method getselectedProduct");
		return "/display";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
