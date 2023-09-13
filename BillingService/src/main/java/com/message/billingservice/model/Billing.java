package com.message.billingservice.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Billing implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int billingId;
	private int orderId;
	private float totalprice;
	private int userId;
	

}
