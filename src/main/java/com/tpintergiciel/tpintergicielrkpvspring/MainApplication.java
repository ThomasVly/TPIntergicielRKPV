package com.tpintergiciel.tpintergicielrkpvspring;

import com.tpintergiciel.tpintergicielrkpvspring.classes.Client;
import com.tpintergiciel.tpintergicielrkpvspring.classes.Msg;
import com.tpintergiciel.tpintergicielrkpvspring.controller.ClientController;
import com.tpintergiciel.tpintergicielrkpvspring.controller.MsgController;
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
    Client client = new Client("David");
    Client client2 = new Client("Manuel");

    Msg msg1 = new Msg(1,"David","Manuel", "ping");

    Msg msg2 = new Msg(2,"Manuel","David", "pong");

    @Autowired
    private ClientController clientController;

    @Autowired
    private MsgController msgController;
    @Bean
    CommandLineRunner sendKafkaMessage(ApplicationContext context) {
        return args -> {
            KafkaProducer producer = context.getBean(KafkaProducer.class);
            producer.writeMessage("Hello Kafka from local!");
            System.out.println("Message envoyé directement à Kafka !");

            clientController.createClient(client);
            clientController.createClient(client2);
            System.out.println(clientController.getAllClients().get(0).getNom());
            System.out.println("yousk2");

            msgController.createMsg(msg1);

            msgController.createMsg(msg2);

        };
    }

}
