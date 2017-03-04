package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.ComponentScan;

@Entity
@ComponentScan
public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	@OneToOne
	@JoinColumn(name = "id")
	private Product p;
	
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "cartId", insertable = false)
	private Shopping cart;

	public Item() {
	}

	public Item(Product p, int quantity) {
		this.p = p;
		this.quantity = quantity;
	}

	
	public int getItemId() {
		return itemId;
	}

	
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	
	public Product getP() {
		return p;
	}

	
	public void setP(Product p) {
		this.p = p;
	}

	public Shopping getCart() {
		return cart;
	}

	
	public void setCart(Shopping cart) {
		this.cart = cart;
	}

	
	public int getQuantity() {
		return quantity;
	}

	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}