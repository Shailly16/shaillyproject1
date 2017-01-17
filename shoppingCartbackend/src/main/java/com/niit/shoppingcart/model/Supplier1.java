package com.niit.shoppingcart.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

@Embeddable
@Table
@Component
public class Supplier1 
{
	
	private String id;
	
	private String name;
	private String address; 
	
	
	@OneToMany(mappedBy="supplier1",fetch=FetchType.EAGER)
	private Set<Product1> products;
	public Set<Product1> getProducts() {
		return products;
	}
	public void setProducts(Set<Product1> products) {
		this.products = products;
	}
	@Id
	@Column(name="Id")
	@GeneratedValue
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
