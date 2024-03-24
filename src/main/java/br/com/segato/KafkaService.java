package br.com.segato;

import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaService {
	
	public KafkaConsumer<String, String> CreateConsumer(String host ,String topic,String name) {
		var consumer = new KafkaConsumer<String, String>(properties(host,name));
		consumer.subscribe(Pattern.compile(topic));
		return consumer;
	}
	
	private static Properties properties(String host,String name) {
		var properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, host);
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, name);
		return properties;

	}

}
