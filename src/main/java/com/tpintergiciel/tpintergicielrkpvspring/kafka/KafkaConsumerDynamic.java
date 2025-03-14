package com.tpintergiciel.tpintergicielrkpvspring.kafka;
import com.tpintergiciel.tpintergicielrkpvspring.classes.Client;
import com.tpintergiciel.tpintergicielrkpvspring.classes.Msg;
import com.tpintergiciel.tpintergicielrkpvspring.repository.MsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaConsumerDynamic {

    @Autowired
    private MsgRepository msgRepository;

    private final ConcurrentKafkaListenerContainerFactory<String, String> factory;
    private final Map<String, ConcurrentMessageListenerContainer<String, String>> containers = new HashMap<>();

    public KafkaConsumerDynamic(ConcurrentKafkaListenerContainerFactory<String, String> factory) {
        this.factory = factory;
    }

    public void createConsumer(String clientName, Client client) {
        String topicName = clientName;  // Chaque client écoute sur un topic nommé comme lui

        if (containers.containsKey(topicName)) {
            System.out.println("Consumer pour " + topicName + " existe déjà !");
            return;
        }

        factory.getContainerProperties().setGroupId("group_" + topicName);
        ConcurrentMessageListenerContainer<String, String> container = factory.createContainer(topicName);
        container.setupMessageListener((MessageListener<String, String>) record -> {
            String message = record.value();
            String beforePlus = message.split("\\+")[0];
            String afterPlus = message.split("\\+")[1];
            Msg msg = new Msg(beforePlus,topicName,afterPlus);
            msgRepository.save(msg);
            client.receiveMessage(record.value());
        });

        container.start();
        containers.put(topicName, container);
        System.out.println("Kafka listener démarré pour le topic : " + topicName);
    }

    public void stopConsumer(String clientName) {
        String topicName = clientName;
        ConcurrentMessageListenerContainer<String, String> container = containers.remove(topicName);
        if (container != null) {
            container.stop();
            System.out.println("Kafka listener arrêté pour le topic : " + topicName);
        }
    }
}
