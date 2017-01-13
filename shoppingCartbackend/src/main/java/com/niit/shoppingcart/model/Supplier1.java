package com.niit.shoppingcart.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

@Embeddable
@Table
@Component(value="supplier1")
public class Supplier1 
{
	
	private String id;
	
	private String name;
	private String address; 
	public Set<Product1> products;
	
	@OneToMany(mappedBy="supplier1",fetch=FetchType.EAGER)
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
