package com.message.billingservice.service;

import com.message.billingservice.model.Billing;

public interface BillingService{
	
	public Billing generateBill(Billing orderBooking) ;
	
}