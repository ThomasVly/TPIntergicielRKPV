package com.tpintergiciel.tpintergicielrkpvspring.controller;

import com.tpintergiciel.tpintergicielrkpvspring.kafka.KafkaProducer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Kafka")
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


