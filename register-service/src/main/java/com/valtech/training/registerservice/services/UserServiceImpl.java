package com.valtech.training.registerservice.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.SubscriptionVO;
import com.valtech.training.registerservice.vos.UserVO;




@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private SubscriptionRepo subRepo;
	
	@Override
	public UserVO createUser(UserVO uvo) {
		return  UserVO.from(userRepo.save(uvo.to(subRepo.getReferenceById(uvo.subscriptionId()))));
	}
	
	@Override
	public UserVO getUser(int id) {
		return UserVO.from(userRepo.getReferenceById(id));
	}
	
	@Override
	public List<UserVO> getAllUsers(){
		return UserVO.from(userRepo.findAll());
	}
	
	@Override
	public List<UserVO> getUsersBySubscription(int id){
		return UserVO.from(userRepo.findAllBySubscriptionId(id));
	}
	
	@Override
	public UserVO signIn(UserVO uvo) {
		Subscription sub = new Subscription();
		sub.setAmount(10000);
		sub.setStartDate(LocalDate.now());
		sub.setEndDate(LocalDate.now().plusYears(1));
//		sub.addUser(uvo.to(sub));
		sub = subRepo.save(sub);
		return UserVO.from(userRepo.save(uvo.to(sub)));
	}

	@Override
	public UserVO addUserToSubscription(UserVO uvo, int subId) {
		Subscription sub = subRepo.getReferenceById(subId);
		User user = uvo.to(sub);
		user = userRepo.save(user);
		return UserVO.from(user);
	}

	@Override
	public void deleteUserFromSubscription(int userId) {
		User user = new User();
		user = userRepo.getReferenceById(userId);
		int subId = user.getSubscription().getId();
		Subscription sub = subRepo.getReferenceById(subId);
		sub.getUsers().remove(user);
		user.setSubscription(null);
		userRepo.delete(user);
		
	}
}
