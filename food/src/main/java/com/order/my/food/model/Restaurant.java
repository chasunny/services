package com.order.my.food.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Restaurant {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	
	private int distance;
	private int price;
	private double rating;
	private String nOfRest;
	
	private String type;
	
//
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(
//		name="restaurant_foodmenu",
//		joinColumns= {
//				@JoinColumn(name="restaurant_id",referencedColumnName = "id")},
//		inverseJoinColumns = {
//				@JoinColumn(name="foodmenu_id",referencedColumnName = "id")})
//	private Set<FoodMenu> foodMenu = new HashSet<>();

	
    public Restaurant() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public String getnOfRest() {
		return nOfRest;
	}


	public void setnOfRest(String nOfRest) {
		this.nOfRest = nOfRest;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	

	public Restaurant(long id, int distance, int price, double rating, String nOfRest, String type) {
		super();
		this.id = id;
		this.distance = distance;
		this.price = price;
		this.rating = rating;
		this.nOfRest = nOfRest;
		this.type = type;
	}

	

}
