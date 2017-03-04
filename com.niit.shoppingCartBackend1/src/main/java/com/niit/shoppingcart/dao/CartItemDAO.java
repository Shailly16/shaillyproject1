package com.niit.shoppingcart.dao;

import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Item;

public interface CartItemDAO {
	void addCartItem(Item cartItem);

    void removeCartItem(Item cartItem);
    Item getCartItemByProductId(int productId);


    void removeAllCartItems(Cart cart);


}
