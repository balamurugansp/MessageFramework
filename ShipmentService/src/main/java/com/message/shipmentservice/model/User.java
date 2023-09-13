package com.message.shipmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class User {

	private Long userId;
	private String fullname;
	private String username;
	private String password;
	private String emailId;
	private String phonenumber;
}