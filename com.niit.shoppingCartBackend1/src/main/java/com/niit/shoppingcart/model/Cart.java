package com.niit.shoppingcart.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String UserID;
	
	@OneToOne
	public String getUserID() {
		return UserID;
	}
	
	private char status;
	
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	@OneToMany(cascade=CascadeType.ALL)
	private List<Item> cartItems;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}
	public List<Item> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<Item> cartItems) {
		this.cartItems = cartItems;
	}
	private double TotalAmount;
}
