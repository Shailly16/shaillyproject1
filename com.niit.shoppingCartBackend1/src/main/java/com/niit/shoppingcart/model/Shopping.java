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

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Shopping")
public class Shopping implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	@OneToOne
	private User user;
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	List<Item> listitem;

	/**
	 * @return the cartId
	
	public int getCartId() {
		return cartId;
	}

	/**
	 * @param cartId
	 *            the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the u
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param u
	 *            the u to set
	 */
	public void setUser(User u) {
		this.user = user;
	}

	/**
	 * @return the listitem
	 */
	public List<Item> getListitem() {
		return listitem;
	}

	/**
	 * @param listitem
	 *            the listitem to set
	 */
	public void setListitem(List<Item> listitem) {
		this.listitem = listitem;
	}

}