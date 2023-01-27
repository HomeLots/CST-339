package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity>
{
	@Autowired
	private DataSource dataSource;
	
	@SuppressWarnings("unused")
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	private OrdersRepository ordersRepository;

	// Non-default constructor for constructor injection
	public void OrdersDataService(OrdersRepository ordersRepository)
	{
		this.ordersRepository = ordersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
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
		// Example of Overriding the CrudRepository save() because it simply is never calles
		// You can inject a dataSource and use the jdbcTemplate to provie a customized implementation of a save() method
		String sql = "INSERT INTO ORDER(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)";
		try
		{
			// Execute SQL insert
			jdbcTemplateObject.update(sql,
					order.getOrderNo(),
					order.getProductName(),
					order.getPrice(),
					order.getQuantity());
		}
		catch(Exception e)
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
