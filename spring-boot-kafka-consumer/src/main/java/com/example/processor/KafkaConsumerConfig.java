package com.example.processor;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.processor.model.User;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	
	@Value("${kafka.broker.address}")
	private String kafkaBrokerAddress;
	
	 @Bean
	    public ConcurrentKafkaListenerContainerFactory<String,User> studentListner()
	    {
	        ConcurrentKafkaListenerContainerFactory<String,User>
	            factory = new ConcurrentKafkaListenerContainerFactory<>();
	        factory.setConsumerFactory(consumerFactory());
	        return factory;
	    }
	
	@Bean
	public ConsumerFactory<String,User> consumerFactory(){
		Map<String,Object> configMap=new HashMap<>();
		configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaBrokerAddress);
		configMap.put(ConsumerConfig.GROUP_ID_CONFIG,"consumer-group");
		configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		return new DefaultKafkaConsumerFactory<>(configMap,new StringDeserializer(),new JsonDeserializer<>(User.class));
		
	}
//refer geeksforGeeks
}
