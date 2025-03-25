package com.valtech.training.registerservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;

public record UserVO(int id,String name, int age, String mobile, String email,int subscriptionId, boolean isKidAccount) {

	
	public static UserVO from(User user) {
		return new UserVO(user.getId(), user.getName(),user.getAge(),user.getMobile(),user.getEmail(),user.getSubscription().getId(),user.isKidAccount());
	}
	public User to(Subscription sub) {
//		Subscription sub = subRepo.get
		User user = new User(name,age,mobile, email, isKidAccount);
		user.setSubscription(sub);
		return user;
	}
	public static List<UserVO> from(List<User> users){
		return users.stream().map(user -> UserVO.from(user)).collect(Collectors.toList());
	}
}
