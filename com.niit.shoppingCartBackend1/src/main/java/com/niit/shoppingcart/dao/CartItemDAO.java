package com.niit.shoppingcart.dao;


import java.util.List;

import com.niit.shoppingcart.model.Item;

public interface CartItemDAO {
	public void addCartItem(Item cartItem);
	
    public void removeCartItem(Item cartItem);
    public Item getCartItemByProductId(String itemId);
    public void updateItem(Item cartitem);

   


}
