package com.example.orderbooking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderbooking.model.OrderBooking;
import com.example.orderbooking.service.OrderBookingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/orderbooking-service")
@Slf4j
public class OrderBookingController {
	
	@Autowired
	private OrderBookingService orderService;
	
	@PostMapping(value = "/createorder" , consumes =  MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderBooking> createOrder (@RequestBody OrderBooking book){
		log.info("book new order {}", book.toString());
		OrderBooking orderBook= orderService.bookOrder(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(orderBook);
		
	}
}
