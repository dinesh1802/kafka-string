package com.example.processor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Kafkaconsumer {

	@KafkaListener(topics="hello-topic",groupId="consumer-group")
	public void consume(String message) {
		System.out.println(message);
	}
}
