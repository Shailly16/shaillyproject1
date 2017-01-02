package com.niit.shoppingCartBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Product1 
{
	@Id
	private String id;
	private String name;
	private String description;
	private float price;
	private String Category_id;
	private String Supplier_id;
	private String stock;
	
}
