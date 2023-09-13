/**
 * 
 */
package com.messagemq.userservice.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

 
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.messagemq.user.mapper.UserMapper;
import com.messagemq.userservice.dto.MessageEvent;
import com.messagemq.userservice.dto.UserEntity;
import com.messagemq.userservice.model.OrderEvent;
import com.messagemq.userservice.model.UserModel;
import com.messagemq.userservice.repository.UserServiceRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserServiceRepository userRepository;
	@Autowired
	private ObjectMapper objectMapper;

	private UserMapper userMapper = new UserMapper();

	@Override
	public Optional<UserModel> getUserById(Long userId) {
		UserModel userModel = userMapper
				.convertToDto(userRepository.findById(userId).orElseThrow(EntityNotFoundException::new));
		Optional<UserModel> optionalUser = Optional.of(userModel);

		return optionalUser;
	}

	@Override
	public UserModel registerUser(UserModel userModel) {
		Long generatedLong = new Random().nextLong();
		userModel.setUserId(generatedLong);
		UserEntity value = userMapper.convertToEntity(userModel);
		UserEntity saveUser = userRepository.save(value);
		UserModel userValue = userMapper.convertToDto(saveUser);
		log.info("Register User Successfully");
		return userValue;
	}

	@KafkaListener(topics = "${topic.name.details}", groupId = "${spring.kafka.consumer.groups-id}")
	public void listenAll(@Payload  OrderEvent event) throws JsonMappingException, JsonProcessingException {
		OrderEvent eventListener = objectMapper.readValue(event.getMessage().toString(), OrderEvent.class);
		log.info("listenAll : {}", eventListener.getMessage().toString());
	}

	@KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void listenFar(@Payload OrderEvent event) throws JsonMappingException, JsonProcessingException {
		OrderEvent eventListener = objectMapper.readValue(event.getMessage().toString(), OrderEvent.class);
		log.info("---listenFar: {}", eventListener.getMessage().toString());
	}
	
	
	@Override
	public void consume(OrderEvent event) throws Exception {
		MessageEvent message = new MessageEvent();
		this.listenAll(event);
		this.listenFar(event);
		message.setMessage(event.getMessage());
		message.setStatus(event.getStatus());
		message.setUserId(event.getUser().getUserId());
		 
	}
}
