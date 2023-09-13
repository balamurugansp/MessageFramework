package com.example.orderbooking.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderEvent {
	@JsonProperty("message")
	private String message;
	@JsonProperty("status")
	private String status;

	@JsonProperty("orderbooking")
	private OrderBooking orderbooking;
	@JsonProperty("user")
	private User user;

}
