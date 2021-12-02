package com.example.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@GetMapping("/hello/{message}")
	public String publish(@PathVariable("message") String publishMessage) {
		kafkaTemplate.send("hello-topic", publishMessage);
		return "message published : "+publishMessage;
	}
}
