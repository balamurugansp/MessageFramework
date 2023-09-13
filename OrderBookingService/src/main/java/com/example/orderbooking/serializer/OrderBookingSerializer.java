package com.example.orderbooking.serializer;

import org.apache.kafka.common.serialization.Serializer;


import com.example.orderbooking.model.OrderEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderBookingSerializer implements Serializer<OrderEvent> {

	@Override
	public byte[] serialize(String topic, OrderEvent data) {
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
