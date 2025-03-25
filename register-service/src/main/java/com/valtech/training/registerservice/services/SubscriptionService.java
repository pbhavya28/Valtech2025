package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.SubscriptionVO;

public interface SubscriptionService {

	SubscriptionVO subscribe(SubscriptionVO subVo);

	SubscriptionVO getSubscription(int id);

	List<SubscriptionVO> getAllSubscriptions();

}