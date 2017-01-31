package com.niit.shoppingcart;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

import junit.framework.Assert;

public class productTestCase {
	@Autowired
   static ProductDAO productDAO1;

	@Autowired
	 static Product product1;
	@Autowired
	 static Supplier supplier;
	
	@Autowired
	 static Category category;
	
	@Autowired
	 static SupplierDAO supplierDAO;
	
	@Autowired
	 static CategoryDAO categoryDAO;
	
	@Autowired
	 static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		product1 = (Product) context.getBean("product");
		productDAO1 =(ProductDAO)context.getBean("productDAOImpl");

	}
	
	@Test
	public void getproductTestCase()
	{ 
	 //assert statements
	System.out.println("UID IS"+product1.getId());
	Assert.assertEquals("PZ002",product1.getId());
	}
	
	
	@Test
	public void saveTestCase()
	{
		
		product1.setId("PZ002");
		product1.setName("MAC_Beauty");
		product1.setDescription(" House No.1,25Street,Boston,USA_201036 ");
		product1.setPrice(200);
		product1.setCategory_id("CA001");
		product1.setSupplier_id("RA002");
		product1.setStock(30);
		
		Assert.assertEquals( "saveTestCase", true, productDAO1.save(product1));
		
	}
	
	
	
	@Test
	public void getAllproductTestCase()
	 {
		
		int size=productDAO1.list().size();
		Assert.assertEquals("length check",1,size);
	 }
	
	
	@Test
	public void updateTestCase()
	{
		// giving id is mandatory as it is primary key.
		
		product1= productDAO1.get("PZ002");
		
		product1.setName("Glow_House");
		Assert.assertEquals( true, productDAO1.update(product1));
		
	}
	}




	
