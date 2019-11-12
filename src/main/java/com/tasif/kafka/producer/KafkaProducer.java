package com.tasif.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

	private final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
	private final String TOPIC = "testtopic";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		log.info(String.format("#### -> Producing message -> %s", message));
		this.kafkaTemplate.send(TOPIC, message);
	}

}
