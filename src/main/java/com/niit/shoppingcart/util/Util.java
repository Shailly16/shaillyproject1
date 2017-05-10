package com.niit.shoppingcart.util;

public class Util {
  
	  public static String removeComman(String field)
	 
	  { return field.replace(",", "");

	  }

	  public static void main(String[] args)
	  {
		  System.out.println(Util.removeComman(",Spring"));
	  }
}