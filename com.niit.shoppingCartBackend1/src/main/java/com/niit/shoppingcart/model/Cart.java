package com.niit.shoppingcart.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Cart implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartid;
	@OneToOne
	private User UserID;
	
	
	public User getUserID(){ 
		return UserID;
	}
	
	private char status;
	
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public void setUserID(User userID) {
		UserID = userID;
	}
	@OneToMany(cascade=CascadeType.ALL)
	List<Item> cartItems;
	
	public int getId() {
		return cartid;
	}
	public void setId(int id) {
		this.cartid = id;
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
