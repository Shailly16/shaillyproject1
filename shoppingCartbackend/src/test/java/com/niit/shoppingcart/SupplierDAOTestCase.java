package com.niit.shoppingcart;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier1;

import junit.framework.Assert;

public class SupplierDAOTestCase {
	@Autowired
	 static SupplierDAO supplierDAO;

	@Autowired
	 static Supplier1 supplier;

	@Autowired
	 static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		supplier = (Supplier1) context.getBean("supplier1");
		supplierDAO =(SupplierDAO)context.getBean("supplierDAOImpl");

	}
	
	@Test
	public void getSupplierTestCase()
	{ 
	 //assert statements
	System.out.println("UID IS"+supplier.getId());
	Assert.assertEquals("RA002",supplier.getId());
	}
	
	@Before
	@Test
	public void saveTestCase()
	{
		
		supplier.setId("RA002");
		supplier.setName("MAC_Beauty");
		supplier.setAddress(" House No.1,25Street,Boston,USA_201036 ");
		
		Assert.assertEquals( true, supplierDAO.save(supplier));
		
	}
	
	
	
	@Test
	public void getAllSupplierTestCase()
	 {
		
		int size=supplierDAO.list().size();
		Assert.assertEquals("length check",1,size);
	 }
	
	
	@Test
	public void updateTestCase()
	{
		// giving id is mandatory as it is primary key.
		
		supplier= supplierDAO.get("RA002");
		
		supplier.setName("Glow_House");
		Assert.assertEquals( true, supplierDAO.update(supplier));
		
	}
	}




	
