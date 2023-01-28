package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController
{
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	@Autowired
	private SecurityBusinessService security;
	
	@GetMapping("/")
	public String display(Model model)
	{
		// Display Login Form View
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
        
        return "login";	
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{		
		// Check for validation errors
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		// Create some orders
		List<OrderModel> orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel("0L", "0000000001", "Product 1", 1.00f, 1));
		orders.add(new OrderModel("1L", "0000000002", "Product 2", 2.00f, 2));
		orders.add(new OrderModel("2L", "0000000003", "Product 3", 3.00f, 3));
		orders.add(new OrderModel("3L", "0000000004", "Product 4", 4.00f, 4));
		orders.add(new OrderModel("4L", "0000000005", "Product 5", 5.00f, 5));
		
		// Call 'test' method from 'service' object thats created from OrdersBusinessServiceInterface
		service.test();
		// Call 'authenticate' method from
		security.authenticate("username", "password");
		
		// Display the Orders View
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", orders);
		return "orders";
		
	}

}