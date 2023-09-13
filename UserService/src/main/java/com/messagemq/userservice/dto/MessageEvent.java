package com.messagemq.userservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "messsageDetail")
public class MessageEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "messageId", unique = true, nullable = false)
	private Integer messageId;

	@Column(name = "userId", nullable = false)
	private Long userId;
	@Column(name = "message", nullable = false)
	private String message;
	@Column(name = "status", nullable = false)
	private String status;

}
