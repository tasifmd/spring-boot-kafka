package com.tasif.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.tasif.kafka.model.User;

@Service
public class KafkaProducer {

	private final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
	private static final String TOPIC = "testtopic";

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	public void sendMessage(User user) {
		log.info(String.format("#### -> Producing message -> %s", user));
		this.kafkaTemplate.send(TOPIC, user);
	}

}
