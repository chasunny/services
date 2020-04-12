package com.order.my.food.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long userid;
  
  private String username;
  private String type;
  private int cost;
  private String item;
  private Date orderTime;
  

public long getUserid() {
	return userid;
}
public void setUserid(long userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
public String getItem() {
	return item;
}
public void setItem(String item) {
	this.item = item;
}
public Date getOrderTime() {
	return orderTime;
}
public void setOrderTime(Time orderTime) {
	this.orderTime = orderTime;
}

public Order(long userid, String username, String type, int cost, String item, Date orderTime) {
	super();
	this.userid = userid;
	this.username = username;
	this.type = type;
	this.cost = cost;
	this.item = item;
	this.orderTime = orderTime;
} 
}
