package com.message.billingservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BillingEvent {
	@JsonProperty("message")
	private String message;
	@JsonProperty("status")
	private String status;

	@JsonProperty("billing")
	private Billing billing;
	@JsonProperty("user")
	private User user;

}
