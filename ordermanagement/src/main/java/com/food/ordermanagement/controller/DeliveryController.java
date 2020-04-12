package com.food.ordermanagement.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.ordermanagement.model.DeliveryBoy;
import com.food.ordermanagement.model.OrderDetails;
import com.food.ordermanagement.service.DeliveryService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.swagger.annotations.ApiOperation;


@RestController
public class DeliveryController {
	
	
	
	

	@Autowired
	DeliveryService ser;
	
	@PostMapping("/order")
	@Transactional
	@Modifying
	@ApiOperation(value ="store order details",
	              notes ="provide order details to store the order data")
	@HystrixCommand(fallbackMethod="getFallBackOrderMethod",commandProperties = {
                     @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
	public String storeOrderDetails(@RequestBody OrderDetails od) throws Exception{     
            Thread.sleep(3000);
            String temp =ser.postOrder(od);
           	
            if(temp != null) {
                   return temp;
            } else {
                   throw new Exception();
            }

	}
	
	@ApiOperation(value ="store order details fall back method",
            notes ="unable to store date")
	public String getFallBackOrderMethod(OrderDetails od) {
		return "order cant be placed";
	}
	
	
	@GetMapping("/deliverboy/{id}")
	@ApiOperation(value ="get delivery details by id",
    notes ="get delivery details of the restauarant",
    response =DeliveryBoy.class)
	public DeliveryBoy getDeliveryBoyDetails(@PathVariable int id)
	{
		return ser.getDelDetails(id);
	}

}
