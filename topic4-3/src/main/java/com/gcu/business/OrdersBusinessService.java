package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrderDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface
{
	@Autowired
	private OrderDataService service;
	
	@Override
	public void test() 
	{
		System.out.println("Hello from the OrdersBusinessService class");
		
	}
	
	@Override
	public List<OrderModel> getOrders() 	
	{
		service.findAll();
		return null;
		
    }

	@Override
	public void init() 
	{
		System.out.println("Hello from init()!");
		
	}

	@Override
	public void destroy() 
	{
		System.out.println("Hello from destroy()!");
		
	}
}
