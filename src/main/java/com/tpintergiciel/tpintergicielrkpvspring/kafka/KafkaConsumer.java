package com.tpintergiciel.tpintergicielrkpvspring.kafka;

import com.tpintergiciel.tpintergicielrkpvspring.classes.Client;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {

    private final List<Client> clients = new ArrayList<>();

    public void registerClient(Client client) {
        clients.add(client);
    }

    @KafkaListener(topics="my_topic", groupId="my_group_id")
    public void getMessage(String message){
        for (Client client : clients) {
            client.receiveMessage(message);
        }
        System.out.println(message);

    }
}
