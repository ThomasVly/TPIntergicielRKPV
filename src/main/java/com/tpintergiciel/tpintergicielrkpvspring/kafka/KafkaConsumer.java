package com.tpintergiciel.tpintergicielrkpvspring.kafka;

import com.tpintergiciel.tpintergicielrkpvspring.classes.Client;
import com.tpintergiciel.tpintergicielrkpvspring.classes.Msg;
import com.tpintergiciel.tpintergicielrkpvspring.repository.MsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {

    @Autowired
    private MsgRepository msgRepository;

    private final List<Client> clients = new ArrayList<>();

    public void registerClient(Client client) {
        clients.add(client);
    }

    @KafkaListener(topics="my_topic", groupId="my_group_id")
    public void getMessage(String message){
        for (Client client : clients) {
            client.receiveMessage(message);
        }
        String beforePlus = message.split("\\+")[0];
        String afterPlus = message.split("\\+")[1];
        Msg msg = new Msg(beforePlus,"my_topic",afterPlus);
        msgRepository.save(msg);
        System.out.println(message);

    }
}
