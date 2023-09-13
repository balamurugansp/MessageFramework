package com.messagemq.userservice.serializer;

import org.apache.kafka.common.serialization.Deserializer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.messagemq.userservice.model.OrderEvent;
 

public class userServiceDeSerilizer implements Deserializer<OrderEvent> {

	@Override
	public OrderEvent deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		OrderEvent event =null;
		try {
			event=	mapper.readValue(data, OrderEvent.class);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return event;
		 
	}

}
