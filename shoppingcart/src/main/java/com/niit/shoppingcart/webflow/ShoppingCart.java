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


import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.BillingAddress;
import com.niit.shoppingcart.model.Item;
import com.niit.shoppingcart.model.ShippingAddress;
import com.niit.shoppingcart.model.Shopping;

@Controller
@Component
public class ShoppingCart {
	
	@Autowired
	ProductDAO productdao;
	Shopping cart1;
	
	
	
	
	
	
	
	
	@RequestMapping("/order/{id}")
	public String ordernow(@PathVariable(value = "id") String id, ModelMap mm, HttpSession session) {
System.out.println("product id is "+id);
		if (session.getAttribute("cart1") == null) {
			System.out.println("cart value is null");
			List<Item> listcart = new ArrayList();
			cart1 = new Shopping();

			listcart.add(new Item(productdao.get(id),1));
			cart1.setListitem(listcart);
			session.setAttribute("cart", cart1);
		} else {
			System.out.println("cart value is not null");
			cart1 = (Shopping) session.getAttribute("cart");
			List<Item> listcart = cart1.getListitem();
			Iterator i=listcart.iterator();
			while(i.hasNext())
			{
				Item f=(Item)i.next();
				System.out.println("quanity is  " +f.getQuantity());
				System.out.println("proudct id is  " +f.getP());
			}
			// using method isExisting here
			int index = isExisting(id, listcart);
			if (index == -1)
				listcart.add(new Item(productdao.get(id),1));
			else {
				int quantity = listcart.get(index).getQuantity() + 1;
				listcart.get(index).setQuantity(quantity);
			}
			cart1.setListitem(listcart);
			session.setAttribute("cart", cart1);
		}
System.out.println("redirect");
		return "redirect:/cart_checkout"; 
	}

	public Shopping initFlow() {
		// System.out.println(product.getPname());
		System.out.println("Data sply to flow");
		return cart1;

	}
	

	
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") String id, HttpSession session,Model m) {
		cart1 = (Shopping) session.getAttribute("cart1");

		List<Item> listcart = (List<Item>) cart1.getListitem();

		int index = isExisting(id, listcart);
		listcart.remove(index);
		cart1.setListitem(listcart);

		session.setAttribute("cart", cart1);
		System.out.println("delete");
	
		
	return "redirect:cart_checkout";
	
	}
	
public BillingAddress getaddress() {
		System.out.println("inside shopping caet");
		
		return new BillingAddress();

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
