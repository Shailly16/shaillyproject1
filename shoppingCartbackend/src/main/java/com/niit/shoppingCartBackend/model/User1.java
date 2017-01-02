package com.niit.shoppingCartBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class User1 
{
	@Id
	private String id;
	private String name;
	private String password;
	private String mail;
	private String contact;
	private String role;

}
