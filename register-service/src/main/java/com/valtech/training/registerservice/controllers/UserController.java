package com.valtech.training.registerservice.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.services.SubscriptionService;
import com.valtech.training.registerservice.services.UserService;
import com.valtech.training.registerservice.vos.SubscriptionVO;
import com.valtech.training.registerservice.vos.UserVO;

import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.POST;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private SubscriptionService subService;
	
	@PostMapping("/")
	public UserVO signIn(@RequestBody UserVO uvo) {
		return userService.signIn(uvo);
	}
	@PostMapping("/subscription/{id}")
	public void addUserInSubscription(@PathVariable("id") int subId,@RequestBody UserVO uvo) {
		 userService.addUserToSubscription(uvo,subId);	 
	}
	@DeleteMapping("/{id}")
	public void deleteUserFromSubscription(@PathVariable("id") int id) {
		userService.deleteUserFromSubscription(id);
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserVO> getUserById(@PathVariable("id") int id) {
		try{
			return ResponseEntity.ok(userService.getUser(id));
		}
		catch(EntityNotFoundException e){
			return ResponseEntity.of(Optional.empty());
		}
	}
	
	
}
