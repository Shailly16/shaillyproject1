package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;

@Entity
@Table(name = "Item")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	@OneToOne
	@JoinColumn(name = "pid")
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

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the p
	 */
	public Product getP() {
		return p;
	}

	/**
	 * @param p
	 *            the p to set
	 */
	public void setP(Product p) {
		this.p = p;
	}

	public Shopping getCart() {
		return cart;
	}

	/**
	 * @param c
	 *            the c to set
	 */
	public void setCart(Shopping cart) {
		this.cart = cart;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}