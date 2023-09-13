package com.message.billingservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
import com.message.billingservice.model.Billing;
import com.message.billingservice.service.BillingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/bill-service")
@Slf4j
public class BillingServiceController {
	
	@Autowired
	private BillingService billService;
	
	@PostMapping(value = "/generatebill" , consumes =  MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Billing> generateBill (@RequestBody Billing bill){
		log.info("Generate bill::: {}", bill.toString());
		Billing finalBill = billService.generateBill(bill);
		return ResponseEntity.status(HttpStatus.CREATED).body(finalBill);
		
	}
}
