package com.messagemq.userservice.payload;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
 

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApiResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus status;
	private boolean isSuccess;

}

