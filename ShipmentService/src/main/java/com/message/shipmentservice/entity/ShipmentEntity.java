package com.message.shipmentservice.entity;

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
@Table(name = "shipment")
public class ShipmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shipmentId", unique = true, nullable = false)
	private int shipmentId;
	
	@Column(name = "billingId", nullable = false)
	private int billingId;

	@Column(name = "orderId", nullable = false)
	private int orderId;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "userId", nullable = false)
	private int userId;
}
