package com.order.my.food.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class FoodMenu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nOfRest;
	private String itemname;
	private int price;
    private String itemtype;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getnOfRest() {
		return nOfRest;
	}
	public void setnOfRest(String nOfRest) {
		this.nOfRest = nOfRest;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getItemtype() {
		return itemtype;
	}
	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}
	
	public FoodMenu(Long id, String nOfRest, String itemname, int price, String itemtype) {
		super();
		this.id = id;
		this.nOfRest = nOfRest;
		this.itemname = itemname;
		this.price = price;
		this.itemtype = itemtype;
	}
	public FoodMenu() {
		super();
	}
    
}
