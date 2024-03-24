package br.com.segato;

import java.time.Duration;

public class LogConsumer {

	public static void main(String[] args) {

		var consumer = new KafkaService().CreateConsumer("localhost:9092", "LOJA.*", EmailConsumer.class.getSimpleName());
		System.out.println("Logging:");
		while (true) {
			var records = consumer.poll(Duration.ofMillis(100));			
			

			for (var record : records) {

				System.out.println(record.key());
				System.out.println(record.value());

			}
		}

	}

}
