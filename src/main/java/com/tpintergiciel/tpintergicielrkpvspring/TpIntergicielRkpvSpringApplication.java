package com.tpintergiciel.tpintergicielrkpvspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.tpintergiciel.tpintergicielrkpvspring.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TpIntergicielRkpvSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpIntergicielRkpvSpringApplication.class, args);
	}
	@Bean
	CommandLineRunner sendKafkaMessage(ApplicationContext context) {
		return args -> {
			KafkaConsumer consumer = context.getBean(KafkaConsumer.class);
			KafkaConsumerDynamic dynamic = context.getBean(KafkaConsumerDynamic.class);
			KafkaProducer producer = context.getBean(KafkaProducer.class);
			Client client1 = new Client(consumer,dynamic, "David");
			Client client2 = new Client(consumer,dynamic, "Manuel");
			producer.writeMessage("Hello Kafka from local!");
			System.out.println("Message envoyé directement à Kafka !");
		};
	}

}
