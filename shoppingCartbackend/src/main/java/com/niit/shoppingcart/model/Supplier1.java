package com.niit.shoppingcart.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier1 
{
	@Id
	@Column(name="id")
	private String id;
	
	private String name;
	private String address; 
	public Set<Product1> product;
	
	@OneToMany(mappedBy="supplier1",fetch=FetchType.EAGER)
	public Set<Product1> getProduct() {
		return product;
	}
	public void setProduct(Set<Product1> product) {
		this.product = product;
	}
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
