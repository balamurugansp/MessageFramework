package com.message.shipmentservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.message.shipmentservice.model.User;

@FeignClient(	name = "user-service", 
				url = "http://localhost:9001",
				path = "/api/v1/user-service")
public interface UserClient {
	@GetMapping(value = "/getuserbyId/{id}", consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id);
}
