package com.niit.shoppingcart.webflow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CartItemDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Address;
import com.niit.shoppingcart.model.Item;
import com.niit.shoppingcart.model.Shopping;

@Controller
@Component
public class ShoppingCart {
	
	@Autowired
	CartItemDAO p;
	
	@Autowired
	ProductDAO productdao;
	Shopping cart;
	Item item;
	
	
	
	@RequestMapping("/Order/{pid}")
	public String ordernow(@PathVariable(value = "pid") String pid, ModelMap mm, HttpSession session) {

		if (session.getAttribute("cart") == null) {
			List<Item> listcart = new ArrayList();
			cart = new Shopping();

			listcart.add(new Item(productdao.get(pid), 1));
			cart.setListitem(listcart);
			session.setAttribute("cart", cart);
		} else {
			cart = (Shopping) session.getAttribute("cart");
			List<Item> listcart = cart.getListitem();
			// using method isExisting here
			int index = isExisting(pid, listcart);
			if (index == -1)
				listcart.add(new Item(productdao.get(pid), 1));
			else {
				int quantity = listcart.get(index).getQuantity() + 1;
				listcart.get(index).setQuantity(quantity);
			}
			cart.setListitem(listcart);
			session.setAttribute("cart", cart);
		} 
System.out.println("redirect");
		return "redirect:/cart_checkout"; // page name
	}

	public Shopping initFlow() {
		// System.out.println(product.getPname());
		System.out.println("Data sply to flow");
		return cart;

	}
	

	
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") String id, HttpSession session,Model m) {
		cart = (Shopping) session.getAttribute("cart1");
         System.out.println("cart id is " +id);
         item.setP(productdao.get(id));
         p.removeCartItem(item);
         
         return "redirect:cart_checkout";
         
         
	}
         

         //System.out.println("shopping" +cart.getCartId());
		/*List<Item> listcart =  cart.getListitem();
*/
		/*Iterator<Item> i=listcart.iterator();
		while(i.hasNext())
		{
			Item o=(Item)i.next();
			System.out.println("valueof" +o);
		}
		
		
		
		int index = isExisting(id, listcart);
		listcart.remove(index);*/
		/*for (int i= 0;i<listcart.size();i++) {
		    listcart.remove(i);
		}
		cart.setListitem(listcart);

		session.setAttribute("cart", cart);
		System.out.println("delete");
	
		
	return "redirect:cart_checkout";
	
	}*/
	
/*public BillingAddress getaddress() {
		System.out.println("inside shopping caet");
		
		return new BillingAddress();

	}
	*/
	
     public Address getaddress() {
		System.out.println("get address");
		
		return new Address();

	}
	
	@SuppressWarnings("unchecked")
	private int isExisting(String id, List<Item> pcart)
	{

		for (int i = 0; i < pcart.size(); i++)

			if (pcart.get(i).getP().getId()==id)
				return i;
		return -1;
	}
	
	
	



}
