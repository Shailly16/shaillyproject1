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
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;


	@Entity
	@ComponentScan
	@Table
	public class Cart implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int cartId;
		@OneToOne
		private User u;
		@OneToMany(cascade=CascadeType.ALL)
		List<Item> listitem;
		/**
		 * @return the cartId
		 */
		public int getCartId() {
			return cartId;
		}
		/**
		 * @param cartId the cartId to set
		 */
		public void setCartId(int cartId) {
			this.cartId = cartId;
		}
		/**
		 * @return the u
		 */
		public User getU() {
			return u;
		}
		/**
		 * @param u the u to set
		 */
		public void setU(User u) {
			this.u = u;
		}
		/**
		 * @return the listitem
		 */
		public List<Item> getListitem() {
			return listitem;
		}
		/**
		 * @param listitem the listitem to set
		 */
		public void setListitem(List<Item> listitem) {
			this.listitem = listitem;
		}
		

	}



