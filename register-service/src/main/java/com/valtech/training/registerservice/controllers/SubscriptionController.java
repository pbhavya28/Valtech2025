package com.valtech.training.registerservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.registerservice.services.SubscriptionService;
import com.valtech.training.registerservice.vos.SubscriptionVO;

@RestController
@RequestMapping("/api/v1/subscription")
public class SubscriptionController {

	@Autowired
	private SubscriptionService subService;
	
	
	@GetMapping("/{id}")
	public SubscriptionVO  getSubscriptionById(@PathVariable("id") int id) {
		return subService.getSubscription(id);
	}
	
	@GetMapping("/")
	public List<SubscriptionVO>  getAllSubscription() {
		return subService.getAllSubscriptions();
	}

	
}
