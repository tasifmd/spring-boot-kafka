package com.tasif.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.kafka.model.User;
import com.tasif.kafka.producer.KafkaProducer;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

	@Autowired
	private KafkaProducer kafkaProducer;

	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestBody User user) {
		this.kafkaProducer.sendMessage(user);
	}

}
