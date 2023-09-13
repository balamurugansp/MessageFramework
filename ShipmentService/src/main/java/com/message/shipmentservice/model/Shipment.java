package com.message.shipmentservice.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shipment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int shipmentId;
	private int billingId;
	private int orderId;
	private String address;
	private int userId;
	private String status;

}
