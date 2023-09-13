package com.messagemq.user.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.messagemq.userservice.dto.MessageEvent;
import com.messagemq.userservice.model.OrderEvent;

@Configuration
@EnableKafka
public class kafkaConfig {
	@Autowired
	private Environment environment;

	@Autowired
	private KafkaProperties kafkaProperties;

	 

	
	@Bean
    public KafkaListenerContainerFactory<?> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        
        factory.setBatchListener(true);
        return factory;
    }
	
	 @Bean
	    public Map<String, Object> consumerConfigs() {
	        Map<String, Object> props = new HashMap<>();
	        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
	        props.put(ConsumerConfig.GROUP_ID_CONFIG, "orderbooking-consumer");
	        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
	        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "com.messagemq.userservice.serializer.userServiceDeSerilizer");
	        return props;
	    }
	@Bean
	public ConsumerFactory<Object, Object> consumerFactory() {
		var properties = kafkaProperties.buildConsumerProperties();
		properties.put(ConsumerConfig.METADATA_MAX_AGE_CONFIG, "120000");
		return new DefaultKafkaConsumerFactory<>(properties);
	}

	 
}
