package com.niit.shoppingcart.model;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.springframework.stereotype.Component;


@Entity
@Table
@Component
public class Supplier implements Serializable 
{
	private static final long serialVersionUID = 1L;
    @Id
    private String sid;
	
	private String name;
	private String address; 
	
	
	@OneToMany(mappedBy="supplier",fetch=FetchType.EAGER)
	private Set<Product> products;
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
	
	
	public String getSid() {
		return sid;
	}
	public void setSid(String id) {
		this.sid = id;
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
