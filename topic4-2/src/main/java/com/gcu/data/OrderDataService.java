package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity>
{
	
	@Autowired
	private OrdersRepository ordersRepository;

	// Non-default constructor for constructor injection
	public void OrdersDataService(OrdersRepository ordersRepository)
	{
		this.ordersRepository = ordersRepository;
	}
	
	/**
	 * CRUD: Finder to return all entities
	 */
	public List<OrderEntity> findAll() 
	{
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		try 
		{
			// Get all of the Entity Orders
			Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();
			
			// Convert to a List and return the List
			orders = new ArrayList<OrderEntity>();
			ordersIterable.forEach(orders::add);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orders;
	}

	/**
	 * CRUD: finder to return a single entity
	 */
	public OrderEntity findById(int id) 
	{
		return null;
	}

	@Override
	public boolean create(OrderEntity order) 
	{
		try
		{
			this.ordersRepository.save(order);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(OrderEntity t) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(OrderEntity t) {
		// TODO Auto-generated method stub
		return true;
	}
	

}
