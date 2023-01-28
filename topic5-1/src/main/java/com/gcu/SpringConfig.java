package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;

@Configuration
public class SpringConfig 
{
	@Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
	//@SessionScope
	//@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public OrdersBusinessServiceInterface getOrdersBusiness()
	{
		return new OrdersBusinessService();
	}

}
