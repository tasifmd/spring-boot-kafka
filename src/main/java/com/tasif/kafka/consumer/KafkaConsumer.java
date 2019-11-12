package com.tasif.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@EnableKafka
public class KafkaConsumer {
	private final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "testtopic", groupId = "group_id")
    public void consume(String message) {
		System.out.println("----------------------\nConsumer\n----------------------");
        log.info(String.format("#### -> Consumed message -> %s", message));
    }
}
