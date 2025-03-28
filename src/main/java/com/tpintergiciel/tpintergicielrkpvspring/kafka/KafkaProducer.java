package com.tpintergiciel.tpintergicielrkpvspring.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    //private static final String TOPIC= "my_topic";
    private static final String TOPIC= "David";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void writeMessage(String msg, String topic, String nom){
        msg=nom+"+"+msg;
        this.kafkaTemplate.send(topic, msg);
        System.out.println("Message sent : "+msg);
    }
}
