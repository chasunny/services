package com.order.my.food.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.order.my.food.feignproxy.FoodProxy;
import com.order.my.food.model.DeliveryBoy;

import com.order.my.food.model.Restaurant;

import com.order.my.food.service.RestServices;

@RestController 
public class MainController {
	
	@Autowired
	FoodProxy prxy;
	
	@Autowired
	RestServices rs;
	
	@Autowired
	EntityManager em;
	
	
	
	
//	@Autowired
//	private KafkaTemplate<String, String> kafkaTemplate;
	
	List<Restaurant> temp=new ArrayList<Restaurant>();
	
	private static final String TOPIC ="order_service";
	
	//kafka
//	@GetMapping("/greeting/{message}")
//	public String post(@PathVariable("message") String message) {
//		kafkaTemplate.send(TOPIC, message);
//		return "Published successfully";
//	}
//	
	
	//fallback method for hystrix no restaurants
//	  public List<Restaurant> fallbackgetByDist(int dist){
//	        return rs.getDetailsbyDist(100);
//	    }
	
	//returning restaurants with distance
	@GetMapping("/dist/{dist}")
//	@HystrixCommand(fallbackMethod="fallbackgetByDist")
    public  List<Restaurant> getDetByDis(@PathVariable int dist) throws Exception
    {
    	List<Restaurant>temp =rs.getDetailsbyDist(dist);
//    	if(dist >=0)
    		return temp;
//    	else
//    		throw new RuntimeException();
//        
    }
    
	//returning restaurants with type
	@GetMapping("/type/{type}")
	public List<Restaurant> getDetByType(@PathVariable String type)
	{
		return rs.getDetailsbyType(type);
	}
	
	
	//returning details with price
	@GetMapping("/price/{price}")
	public List<Restaurant> getDetByprice(@PathVariable int price)
	{
		return rs.getDetailsbyPrice(price);
	}
	
	//get details with rating
	@GetMapping("/rating/{rating}")
	public List<Restaurant> getDetByRating(@PathVariable double rating)
	{
		return rs.getDetailsbyRating(rating);
	}
	
	//menu details
	@GetMapping("/name/{name}/type/{type}")
	public List getMenuDetails(@PathVariable String name,@PathVariable String type)
	{
		return rs.getMenuDetails(name, type);
	}
	
	@GetMapping("orderdetails/dboy/username/{username}/restname/{restname}/item/{item}/price/{price}")
	@Transactional
	@Modifying
	public DeliveryBoy getOrderBoyDetails(@PathVariable String username,@PathVariable String restname,@PathVariable String item,@PathVariable int price)
	{
		return prxy.getBoyDetails(username, restname, item, price);
	}
}
