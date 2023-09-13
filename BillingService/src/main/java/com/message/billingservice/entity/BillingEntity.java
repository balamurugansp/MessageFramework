package com.message.billingservice.entity;

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
@Table(name="billing")
public class BillingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "billingId", unique = true, nullable = false)
	private int billingId;

	@Column(name = "orderId", nullable = false)
	private int orderId;

	@Column(name = "totalprice", nullable = false)
	private float totalprice;
 
	@Column(name = "userId", nullable = false)
	private int userId;

}
