package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component(value="user1")
public class User1 
{
	
	
	private String id;
	@NotBlank(message="Enter UserName")
	private String name;
	@Min(15)
	@Max(15)
	@NotBlank(message="Specify Password")
	private String password;
	@Column(unique=true,nullable=false)
	@NotBlank(message="Specify Email")
	private String mail;
	@NotBlank(message="Specify Contact")
	private String contact;
	@NotBlank(message="Specify Role")
	private String role;
	@Id
	@Column(name= "id")
    public String getId() {
		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
