package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.UserVO;

public interface UserService {

	UserVO createUser(UserVO uvo);

	UserVO getUser(int id);

	List<UserVO> getAllUsers();

	List<UserVO> getUsersBySubscription(int id);

	UserVO signIn(UserVO uvo);

	UserVO addUserToSubscription(UserVO uvo, int subId);

	void deleteUserFromSubscription(int id);

}