package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Address;
import com.niit.shoppingcart.model.Contact;
import com.niit.shoppingcart.model.User;

public interface UserDAO {
	
public List<User> list(); 
	
public User get(String id);
	
public boolean delete(String id) ;
public User getByName(String name);
public User getUserDetails(String hql);
public void saveOrUpdate(User user1);	
public boolean save(User user1); 
public User validate(String id, String password); 
public boolean update(User user1);
public String insertAddress(Address address);
public boolean addContact(Contact contact);




}

