package br.com.segato;

import java.time.Duration;

public class EmailConsumer {

	public static void main(String[] args) {

		var consumer = new KafkaService().CreateConsumer("localhost:9092", "LOJA_EMAIL", EmailConsumer.class.getSimpleName());
		System.out.println("Checking for emails:");
		while (true) {
			var records = consumer.poll(Duration.ofMillis(100));			
			

			for (var record : records) {

				System.out.println(record.key());
				System.out.println(record.value());

			}
		}

	}

	
}
