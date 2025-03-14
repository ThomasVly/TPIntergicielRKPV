package com.tpintergiciel.tpintergicielrkpvspring.controller;

import com.tpintergiciel.tpintergicielrkpvspring.kafka.KafkaProducer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class KafkaController {

    private final KafkaProducer producer;

    public KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public void writeMessageToTopic(@RequestParam("message") String message,String topic,String nom){
        this.producer.writeMessage(message,topic,nom);

    }

}


