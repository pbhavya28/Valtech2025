package com.valtech.assignment.ordermanagement.controllers;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valtech.assignment.ordermanagement.entities.Item;
import com.valtech.assignment.ordermanagement.services.ItemService;
import com.valtech.assignment.ordermanagement.vos.ItemVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@PostMapping("/item")
	public String addInventory(@ModelAttribute ItemVO item, Model model) {
//		System.out.println("itemmmmmmm"+item.getCurrentQty());
			
		itemService.saveItem(item);
		Item item1 = item.to();
		int id = item1.getId();
		System.out.println("jjjjjjjjjjjjjjjiiiiiiiiiiiiii----"+ id);
//		item = null;
		model.addAttribute("item", itemService.getItems());
//		model.addAttribute("item",item);
		return "item";
	}
	@GetMapping("/item")
	public String itemsPage(Model model) {
		model.addAttribute("item", itemService.getItems());
		System.out.println("itemmmmmmm");

		return "item";
	}
	
}
