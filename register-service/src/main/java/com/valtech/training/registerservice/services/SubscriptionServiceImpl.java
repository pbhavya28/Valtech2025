package com.valtech.training.registerservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.vos.SubscriptionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepo subRepo;
	
	@Override
	public SubscriptionVO subscribe(SubscriptionVO subVo) {
		System.out.println(subVo.toString() + subVo.endDate());
		return SubscriptionVO.from(subRepo.save(subVo.to(subRepo.getReferenceById(subVo.id()).getUsers())));
	}
	@Override
	public SubscriptionVO getSubscription(int id) {
		return SubscriptionVO.from(subRepo.getReferenceById(id));
	}
	@Override
	public List<SubscriptionVO> getAllSubscriptions(){
		return SubscriptionVO.from(subRepo.findAll());
	}
	
}
