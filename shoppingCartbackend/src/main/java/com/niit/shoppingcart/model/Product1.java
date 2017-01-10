package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Product1 
{
	@Id
	@Column(name="id")
	private String id;
	private String name;
	private String description;
	private float price;
	@ManyToOne
	@JoinColumn(name="category_id", updatable=false, insertable=false, nullable=false)
	private String Category_id;
	@ManyToOne
	@JoinColumn(name="supplier_id", updatable=false, insertable=false,nullable=false)
	private String Supplier_id;
	private String stock;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCategory_id() {
		return Category_id;
	}
	public void setCategory_id(String category_id) {
		Category_id = category_id;
	}
	public String getSupplier_id() {
		return Supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		Supplier_id = supplier_id;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	
	
}
