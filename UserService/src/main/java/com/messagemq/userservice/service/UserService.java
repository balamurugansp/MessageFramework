package com.messagemq.userservice.service;

import java.util.Optional;

 
import com.messagemq.userservice.model.OrderEvent;
import com.messagemq.userservice.model.UserModel;

public interface UserService {
	public UserModel registerUser(UserModel request);

	public Optional<UserModel> getUserById(Long userId);
	
	public void consume(OrderEvent event)  throws Exception;
}
