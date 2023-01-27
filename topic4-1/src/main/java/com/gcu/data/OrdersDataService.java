package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.model.OrderModel;

@Service
public class OrdersDataService implements DataAccessInterface <OrderModel>
{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-Default constructor for constructor injection
	 */
	public OrdersDataService(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	 @Override
	 public List<OrderModel> findAll() 
	 {
		String sql = "SELECT * FROM ORDERS";
	    List<OrderModel> orders = new ArrayList<>();
		
	    try 
	    {
	    	// Execute SQL Query and loop over result set
	    	SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
	    	while(srs.next())
	    	{
	    		orders.add(new OrderModel(srs.getLong("ID"),
	    				srs.getString("ORDER_NO"),
	    				srs.getString("PRODUCT_NAME"),
	    				srs.getFloat("PRICE"),
	    				srs.getInt("QUANTITY")));
	    	}
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	     
	     return orders;	 
	 }

	@Override
	public OrderModel findById(int id) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(OrderModel order) 
	{
		String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?)";
		try 
		{
			// Execute SQL Insert
			int rows = jdbcTemplateObject.update(sql, 
					order.getOrderNo(),
					order.getProductName(),
					order.getPrice(),
					order.getQuantity());
            
            // Return result of Insert
            return rows == 1 ? true: false;
            						
           }
		
		catch (Exception e)
		{
            e.printStackTrace();
        }
      
		return false;
	}

	@Override
	public boolean update(OrderModel t) 
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(OrderModel t) 
	{
		// TODO Auto-generated method stub
		return true;
	}

}
