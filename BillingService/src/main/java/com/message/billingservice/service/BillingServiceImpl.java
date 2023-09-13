package com.message.billingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.message.billingservice.entity.BillingEntity;
import com.message.billingservice.feignclient.UserClient;
import com.message.billingservice.mapper.BillingMapper;
import com.message.billingservice.model.Billing;
import com.message.billingservice.model.BillingEvent;
import com.message.billingservice.model.User;
import com.message.billingservice.repository.BillingServiceRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BillingServiceImpl implements BillingService {

	@Value("${topic.name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, BillingEvent> kafkaTemplate;
	@Autowired
	private UserClient userClient;

	@Autowired
	private BillingServiceRepository billServiceRepo;
	

	private BillingMapper mapper = new BillingMapper();

	public void sendMessage(BillingEvent event) {
		log.info(String.format("logger Event ==>%s", event.toString()));
		Message<BillingEvent> message = MessageBuilder
				.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC, topicName)
				.build();
		kafkaTemplate.send(message);
	}

	 
	@Override
	public Billing generateBill(Billing bill) {
		ResponseEntity<User> response = userClient.getUserById(bill.getUserId());
		BillingEntity entity = mapper.convertToEntity(bill);
		BillingEntity savedEntity = billServiceRepo.save(entity);
		Billing finalbill = mapper.convertToModel(savedEntity);
		BillingEvent event = new BillingEvent();
		event.setMessage("Successfully generate bill Order for user:::" + bill.getUserId());
		 
		event.setUser(response.getBody());
		event.setStatus("Pending");
		this.sendMessage(event);
		return finalbill;

	}
}
