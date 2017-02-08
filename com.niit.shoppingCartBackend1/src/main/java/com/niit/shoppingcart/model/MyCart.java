package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class MyCart implements Serializable {
private static final long serialVersionUID = 1L;


@Id
private Long id;



@Column(name="user_id")
private String userID;



@Column(name="add_product")
private String productName;
private double price;

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

private char status;

//@Transient()
@Column(name="add_date")
private Date addedDate;

public Long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getUserID() {
	return userID;
}

public void setUserID(String userID) {
	this.userID = userID;
}


public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public char getStatus() {
	return status;
}

public void setStatus(char status) {
	this.status = status;
}

public Date getAddedDate() {
	return addedDate;
}

public void setAddedDate(Date addedDate) {
	this.addedDate = addedDate;
}

public Long setId(Long maxId) {
	return maxId;
	
}


	
}







