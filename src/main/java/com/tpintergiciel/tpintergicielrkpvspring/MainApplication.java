package com.tpintergiciel.tpintergicielrkpvspring;

import com.tpintergiciel.tpintergicielrkpvspring.classes.Client;
import com.tpintergiciel.tpintergicielrkpvspring.classes.Msg;
import com.tpintergiciel.tpintergicielrkpvspring.controller.ClientController;
import com.tpintergiciel.tpintergicielrkpvspring.controller.MsgController;
import com.tpintergiciel.tpintergicielrkpvspring.kafka.KafkaConsumer;
import com.tpintergiciel.tpintergicielrkpvspring.kafka.KafkaConsumerDynamic;
import com.tpintergiciel.tpintergicielrkpvspring.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }


    Msg msg1 = new Msg("David","Manuel", "ping");

    Msg msg2 = new Msg("Manuel","David", "pong");

    @Autowired
    private ClientController clientController;

    @Autowired
    private MsgController msgController;
    @Bean
    CommandLineRunner sendKafkaMessage(ApplicationContext context) {
        return args -> {
            KafkaProducer producer = context.getBean(KafkaProducer.class);
            KafkaConsumer consumer = context.getBean(KafkaConsumer.class);
            KafkaConsumerDynamic dynamic = context.getBean(KafkaConsumerDynamic.class);
            Client client = new Client(consumer,dynamic,"David");
            Client client2 = new Client(consumer,dynamic,"Manuel");
            Client client3 = new Client(consumer,dynamic,"Francis");
            producer.writeMessage("Hello Kafka from local!","Manuel","David");
            System.out.println("Message envoyé directement à Kafka !");

            clientController.createClient(client);
            clientController.createClient(client2);
            clientController.createClient(client3);
            System.out.println(clientController.getAllClients().get(0).getNom());
            System.out.println("yousk2");


        };
    }

}
