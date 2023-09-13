package com.message.billingservice.serializer;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.message.billingservice.model.BillingEvent;

public class BiilingServiceSerializer implements Serializer<BillingEvent> {

	@Override
	public byte[] serialize(String topic, BillingEvent data) {
		byte[] retVal = null;
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			retVal = objectMapper.writeValueAsString(data.toString()).getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	@Override
	public void close() {
		System.out.println("CLOSE SUCCESSSFULLY SERIALIZER IN KAFKA");
	}
 
}
