package com.tasif.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.kafka.producer.KafkaProducer;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

	@Autowired
	private KafkaProducer kafkaProducer;

	@GetMapping(value = "/publish/{message}")
	public void sendMessageToKafkaTopic(@PathVariable("message") String message) {
		this.kafkaProducer.sendMessage(message);
	}

}
