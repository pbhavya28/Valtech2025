package com.valtech.assignment.ordermanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.assignment.ordermanagement.entities.Item;
import com.valtech.assignment.ordermanagement.services.CustomerService;
import com.valtech.assignment.ordermanagement.services.ItemService;
import com.valtech.assignment.ordermanagement.vos.CustomerVO;
import com.valtech.assignment.ordermanagement.vos.ItemVO;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public String addInventory(@ModelAttribute CustomerVO customer, Model model) {
//		System.out.println("itemmmmmmm"+item.getCurrentQty());
			
		customerService.saveCustomer(customer);
//		Item item1 = item.to();
//		int id = item1.getId();
//		System.out.println("jjjjjjjjjjjjjjjiiiiiiiiiiiiii----"+ id);
//		item = null;
		model.addAttribute("customer", customerService.getCustomers());
//		model.addAttribute("item",item);
		return "customer";
	}
	@GetMapping("/customer")
	public String itemsPage(Model model) {
		model.addAttribute("customer", customerService.getCustomers());
		System.out.println("customerrrr");

		return "customer";
	}
}
