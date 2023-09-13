package com.messagemq.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderBooking {
	private int orderId;
	private String itemName;
	private int quantity;
	private int totalItem;
	private int totalquantity;
	private int userId;
 

}
