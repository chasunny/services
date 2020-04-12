package com.order.my.food.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.order.my.food.model.FoodMenu;
import com.order.my.food.model.Order;
import com.order.my.food.model.Restaurant;
import com.order.my.food.repository.RepoImplementation;

//distance,type,price ,rating,Item,name_of_restaurants

@Service
public class RestServices{
	
	@Autowired
	RepoImplementation rst;
	
	
	@Autowired
	EntityManager em;
	
	
	//returning name of the restaurant with distance
	public List<Restaurant> getDetailsbyDist(int dist)
	{
		   return rst.findRestByDistance(dist);
	}
	
	
	//returning name of the restaurant with type
		public List<Restaurant> getDetailsbyType(String type)
		{
			   return rst.findRestByType(type);
		}
	
	
		//returning name of the restaurant with price
		public List<Restaurant> getDetailsbyPrice(int price)
		{
			   return rst.findRestByPrice(price);
		}
		
		//returning name of the restaurant with rating
		public List<Restaurant> getDetailsbyRating(double rating)
		{
		   return rst.findRestByRating(rating);
		}
		
		public List getMenuDetails(String name,String type)
		{
			return rst.findItemList(name, type);
		}
}
