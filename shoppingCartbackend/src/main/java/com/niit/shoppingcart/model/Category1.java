package com.niit.shoppingcart.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
//@Entity
@Embeddable
@Table
@Component(value="category1")
public class Category1 
{
	
	private String id;
	private String name;
	private String description;
    public Set<Product1> products;
	
	@OneToMany(mappedBy="Category1",fetch=FetchType.EAGER)
	public Set<Product1> getProducts() {
		return products;
	}
	public void setProducts(Set<Product1> products) {
		this.products = products;
	}
	@Id
	@Column(name="id")
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
	

}
