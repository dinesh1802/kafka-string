package com.example.processor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.processor.model.User;

@Service
public class Kafkaconsumer {

	@KafkaListener(topics="hello-topic",groupId="consumer-group")
	public void consume(User user) {
		System.out.println(user);
	}
}
