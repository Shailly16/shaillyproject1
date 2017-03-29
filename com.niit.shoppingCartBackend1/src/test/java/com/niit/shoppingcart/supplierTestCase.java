/*package com.niit.shoppingcart;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

import junit.framework.Assert;

public class supplierTestCase {
	@Autowired
	 static SupplierDAO supplierDAO1;

	@Autowired
	 static Supplier supplier1;

	@Autowired
	 static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		supplier1 = (Supplier) context.getBean("supplier");
		supplierDAO1 =(SupplierDAO)context.getBean("supplierDAOImpl");

	}
	
	@Test
	public void getsupplierTestCase()
	{ 
	 //assert statements
	System.out.println("UID IS"+supplier1.getSid());
	Assert.assertEquals("RA002",supplier1.getSid());
	}
	
	@Test
	public void getAllsupplierTestCase()
	 {
		
		int size=supplierDAO1.list().size();
		Assert.assertEquals("length check",1,size);
	 }
	
	
	@Test
	public void saveTestCase()
	{
		
		supplier1.setSid("RA002");
		supplier1.setName("MAC_Beauty");
		supplier1.setAddress(" House No.1,25Street,Boston,USA_201036 ");
		
		Assert.assertEquals( "saveTestCase", true, supplierDAO1.save(supplier1));
		
	}
	
	
	
	
	
	
	@Test
	public void updateTestCase()
	{
		// giving id is mandatory as it is primary key.
		
		supplier1= supplierDAO1.get("RA002");
		
		supplier1.setName("Glow_House");
		Assert.assertEquals( true, supplierDAO1.update(supplier1));
		
	}
	}




	
*/