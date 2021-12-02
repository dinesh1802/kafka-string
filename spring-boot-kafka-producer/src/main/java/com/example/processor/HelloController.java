package com.example.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.processor.model.User;

@RestController
public class HelloController {

	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;
	
	
	@GetMapping("/hello/{name}")
	public String publish(@PathVariable("name") String name) {
		kafkaTemplate.send("hello-topic", new User(name,"dev"));
		return "message published !";
	}
}
