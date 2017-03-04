package com.niit.shoppingcart.model;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Category implements Serializable 
{
	private static final long serialVersionUID = 1L;
    @Id
    private String cid;
    
  
	public String getCid() {
		return cid;
	}
	public void setCid(String id) {
		this.cid = id;
	}
	private String name;
	private String description; 
	
	@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
	private Set<Product> products;
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;}
	
	 
		
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return description;
	}
	public void setAddress(String description) {
		this.description = description;
	}
	

}
