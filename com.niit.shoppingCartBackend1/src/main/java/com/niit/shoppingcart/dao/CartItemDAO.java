package com.niit.shoppingcart.dao;


import com.niit.shoppingcart.model.Item;

public interface CartItemDAO {
	void addCartItem(Item cartItem);

    void removeCartItem(Item cartItem);
    Item getCartItemByProductId(String productId);


   


}
