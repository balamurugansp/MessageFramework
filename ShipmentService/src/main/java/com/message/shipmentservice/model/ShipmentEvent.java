package com.message.shipmentservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShipmentEvent {
	@JsonProperty("message")
	private String message;
	@JsonProperty("status")
	private String status;

	@JsonProperty("shipment")
	private Shipment shipment;
	@JsonProperty("user")
	private User user;

}
