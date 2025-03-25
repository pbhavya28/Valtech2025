package com.valtech.training.registerservice.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.services.SubscriptionService;
import com.valtech.training.registerservice.services.SubscriptionServiceImpl;
import com.valtech.training.registerservice.vos.SubscriptionVO;

public class Demo {


	public static void main(String[] args) {
		
		
		SubscriptionService service = new SubscriptionServiceImpl();
		LocalDate date1 = LocalDate.parse("2021-01-07");
		LocalDate date2 = LocalDate.parse("2028-01-07");
		User user = new User();
		 user.setId(2);
		user.setName("Shaakaal");
		user.setEmail("shaakaal@shaan.com");
		user.setMobile("9998887776");
		user.setAge(39);
		user.setKidAccount(false);
		
		Subscription sub = new Subscription();
		 sub.setId(6);
		sub.setAmount(900);
		sub.setStartDate(date1);
		sub.setEndDate(date2);
		sub.addUser(user);
		SubscriptionVO svo = SubscriptionVO.from(sub);
		service.subscribe(svo);
		
		
	}
}
