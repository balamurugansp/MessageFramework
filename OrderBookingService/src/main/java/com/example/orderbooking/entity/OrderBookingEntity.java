package com.example.orderbooking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orderbooking")
public class OrderBookingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId", unique = true, nullable = false)
	private int orderId;

	@Column(name = "itemName", nullable = false)
	private String itemName;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@Column(name = "totalItem", nullable = false)
	private int totalItem;

	@Column(name = "totalquantity", nullable = false)
	private int totalquantity;
	
	@Column(name = "userId", nullable = false)
	private int userId;

}
