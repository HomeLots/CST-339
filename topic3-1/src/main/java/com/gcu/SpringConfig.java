package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.AnotherOrdersBusinessService;
import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;

@Configuration
public class SpringConfig 
{
	@Bean(name="getOrdersBusiness")
	public OrdersBusinessServiceInterface getOrdersBusiness()
	{
		return new OrdersBusinessService();
	}

}
