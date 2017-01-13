package com.niit.shoppingcart;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product1;

import junit.framework.Assert;

public class ProductDAOTestCase {
	@Autowired
	 static ProductDAO productDAO;

	@Autowired
	 static Product1 product;

	@Autowired
	 static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		product = (Product1) context.getBean("product1");
		productDAO =(ProductDAO)context.getBean("productDAOImpl");
		
	}
	@Before
	@Test
	public void getProductTestCase()
	{ //product=productDAO.get("NIITPV");  
	 //assert statements
	System.out.println("UID IS"+product.getId());
	Assert.assertEquals("Product Test Case ","BZ001",product.getId());// niit is expected whereas product.getName() will give the entered actual input.
	//Assert.assertNotNull("getProductTestCase", product);// productDAO must not return null object.
	}
	
	@Before
	@Test
	public void saveTestCase()
	{
		
		product.setId("BZ001");
		product.setName("M.A.C Compaq");
		product.setDescription("The best seller of the year");
		product.setPrice("1000");
		product.setCategory_id("LP001");
		product.setSupplier_id("RA002");
		product.setStock("200");
		Assert.assertEquals("saveTestCase", true, productDAO.save(product));
		
	}
	@Before
	@Test
	public void updateTestCase()
	{
		// giving id is mandatory as it is primary key.
		
		product= productDAO.get("BZ001");
		
		product.setStock("130");
		Assert.assertEquals("updateTestCase", true, productDAO.update(product));
		
	}
	


	
	@Before
	@Test
	public void getAllProductTestCase()
	 {
		int size = productDAO.list().size();
		Assert.assertEquals("length check",1,size);
	 }
	
}
	


	
