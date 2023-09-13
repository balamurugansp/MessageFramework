package com.message.shipmentservice.serializer;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.message.shipmentservice.model.ShipmentEvent;

public class ShipmentServiceSerializer implements Serializer<ShipmentEvent> {

	@Override
	public byte[] serialize(String topic, ShipmentEvent data) {
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
