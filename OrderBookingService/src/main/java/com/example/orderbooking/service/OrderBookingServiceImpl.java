package com.example.orderbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.orderbooking.entity.OrderBookingEntity;
import com.example.orderbooking.feignclient.UserClient;
import com.example.orderbooking.mapper.OrderBookingMapper;
import com.example.orderbooking.model.OrderBooking;
import com.example.orderbooking.model.OrderEvent;
import com.example.orderbooking.model.User;
import com.example.orderbooking.repository.OrderBookingRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderBookingServiceImpl implements OrderBookingService {

	@Value("${topic.name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, OrderEvent> kafkaTemplate;

	@Autowired
	private OrderBookingRepository orderBookingRepo;
	@Autowired
	private UserClient userClient;

	private OrderBookingMapper mapper = new OrderBookingMapper();

	public void sendMessage(OrderEvent event) {
		log.info(String.format("logger Event ==>%s", event.toString()));
		Message<OrderEvent> message = MessageBuilder
				.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC, topicName)
				.build();
		kafkaTemplate.send(message);
	}

	@Override
	public OrderBooking bookOrder(OrderBooking orderBooking) {
		ResponseEntity<User> response = userClient.getUserById(orderBooking.getUserId());
		OrderBookingEntity entity = mapper.convertToEntity(orderBooking);
		OrderBookingEntity savedEntity = orderBookingRepo.save(entity);
		OrderBooking book = mapper.convertToModel(savedEntity);
		OrderEvent event = new OrderEvent();
		event.setMessage("Successfully book Order for user:::" + orderBooking.getUserId());
		event.setOrderbooking(book);
		event.setUser(response.getBody());
		event.setStatus("Pending");
		this.sendMessage(event);
		return book;

	}
}
