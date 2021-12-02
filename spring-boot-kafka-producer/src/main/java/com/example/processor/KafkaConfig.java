package com.example.processor;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

public class KafkaConfig {

	@Bean
	public KafkaTemplate<String, String> getobj(){
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean
	private ProducerFactory<String, String> producerFactory() {
		Map<String,Object> configProbs= new HashMap<String,Object>();
		configProbs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configProbs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProbs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class );
		return new DefaultKafkaProducerFactory<>(configProbs);
	}
}
