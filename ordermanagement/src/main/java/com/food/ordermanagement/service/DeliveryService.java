package com.food.ordermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


import com.food.ordermanagement.model.DeliveryBoy;
import com.food.ordermanagement.model.OrderDetails;
import com.food.ordermanagement.model.Restaurant;
import com.food.ordermanagement.repository.RestaurantRepo;

@Service
public class DeliveryService {
   
	@Autowired
	RestaurantRepo repo;
	
	
	//kafka listener
      @KafkaListener(topics = "kafke_producer_messaging", groupId = "group_json", containerFactory = "concurrentKafkaListenerContainerFactory")
	  public void consume(String brokerMessage) {
	   System.out.println("message: " + brokerMessage.toString());
		 }
	
      
	public String postOrder(OrderDetails od) throws Exception 
	{
	    return  repo.postOrderDetails(od);	
	}
	
	
	public DeliveryBoy getDelDetails(int id)
	{
		return repo.getDeliveryBoyDetails(id);
	}
	
	
	
}
