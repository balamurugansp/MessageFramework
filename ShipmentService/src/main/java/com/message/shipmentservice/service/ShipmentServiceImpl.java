package com.message.shipmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.message.shipmentservice.model.ShipmentEvent;
import com.message.shipmentservice.model.User;
import com.message.shipmentservice.repository.ShipmentRepository;
import com.message.shipmentservice.entity.ShipmentEntity;
import com.message.shipmentservice.feignclient.UserClient;
import com.message.shipmentservice.mapper.ShipmentMapper;
import com.message.shipmentservice.model.Shipment;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShipmentServiceImpl implements ShipmentService {

	@Value("${topic.name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, ShipmentEvent> kafkaTemplate;
	@Autowired
	private UserClient userClient;
	
	@Autowired
	private ShipmentRepository shipmentRepo;
	
	private ShipmentMapper mapper = new ShipmentMapper();

	@Override
	public Shipment createShipment(Shipment shipment) {
		ResponseEntity<User> response = userClient.getUserById(shipment.getUserId());
		
		ShipmentEntity entity = mapper.convertToEntity(shipment);
		ShipmentEntity savedEntity = shipmentRepo.save(entity);
		Shipment shipmentval = mapper.convertToModel(savedEntity);
		ShipmentEvent event = new ShipmentEvent();
		event.setMessage("Successfully generate bill Order for user:::" + shipment.getUserId());
		event.setUser(response.getBody());
		event.setStatus("Completed");
		this.sendMessage(event);
		return shipmentval;
	}
	
	public void sendMessage(ShipmentEvent event) {
		log.info(String.format("logger Event ==>%s", event.toString()));
		Message<ShipmentEvent> message = MessageBuilder
				.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC, topicName)
				.build();
		kafkaTemplate.send(message);
	}

}
