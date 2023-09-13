package com.messagemq.userservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.messagemq.userservice.model.OrderEvent;
import com.messagemq.userservice.model.UserModel;
import com.messagemq.userservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/user-service")
class UserController {

	@Autowired
	private  UserService userService;

	@PostMapping(value = "/registeruser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserModel> createUser(@RequestBody UserModel request) {
		log.info("Creating user with {}", request.toString());
		UserModel user = userService.registerUser(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	
	@GetMapping(value = "/getuserbyId/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserModel> getUser(@PathVariable("id") Long id) throws Exception {
		log.info("Reading user by id {}", id);
		Optional<UserModel> user = userService.getUserById(id);
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			throw new  Exception();
		}
	}
	
	 @GetMapping(value="/notify",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	 public void consumeNotification(OrderEvent event)throws Exception{
		 userService.consume(event);
	 }

	 

}