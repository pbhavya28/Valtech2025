package com.valtech.assignment.ordermanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.assignment.ordermanagement.entities.LineOrder;
import com.valtech.assignment.ordermanagement.entities.Orders;
import com.valtech.assignment.ordermanagement.entities.Orders.Status;
import com.valtech.assignment.ordermanagement.repos.CustomerRepo;
import com.valtech.assignment.ordermanagement.services.CustomerService;
import com.valtech.assignment.ordermanagement.services.ItemService;
import com.valtech.assignment.ordermanagement.services.LineOrderService;
import com.valtech.assignment.ordermanagement.services.OrderService;
import com.valtech.assignment.ordermanagement.vos.CustomerVO;
import com.valtech.assignment.ordermanagement.vos.LineOrderVO;
import com.valtech.assignment.ordermanagement.vos.OrderVO;
import com.valtech.assignment.ordermanagement.vos.PlaceOrderVO;

@Controller
public class PlaceOrderController {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private LineOrderService lineOrderService;
	
	@PostMapping("/placeOrder")
	public String addInventory(@ModelAttribute PlaceOrderVO placeOrderVO, Model model) {
	
	    orderService.saveOrder(placeOrderVO);
	    model.addAttribute("item", itemService.getItems());
//		orderService.saveOrder(po);
		System.out.println("ooooooooooooooooooooooooooooo");
		return "placeOrder";
	}
	@GetMapping("/placeOrder")
	public String itemsPage(Model model) {
		model.addAttribute("item", itemService.getItems());
		return "placeOrder";
	}
}
