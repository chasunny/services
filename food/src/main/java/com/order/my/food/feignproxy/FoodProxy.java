package com.order.my.food.feignproxy;



import javax.transaction.Transactional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.order.my.food.model.DeliveryBoy;


@FeignClient(name ="netflix-zuul-api-gateway-server")
@RibbonClient(name ="order-management")
public interface FoodProxy {
		
	    
		@GetMapping("/order-management/dboy/username/{username}/restname/{restname}/item/{item}/price/{price}")
		@Transactional
		@Modifying
		@ResponseBody
		public DeliveryBoy getBoyDetails(@PathVariable String username,@PathVariable
				String restname,
				@PathVariable String item,
				@PathVariable int price);
	}