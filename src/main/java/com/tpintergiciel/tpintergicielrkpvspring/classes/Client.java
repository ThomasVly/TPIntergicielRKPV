package com.tpintergiciel.tpintergicielrkpvspring.classes;

import com.tpintergiciel.tpintergicielrkpvspring.kafka.KafkaConsumer;
import com.tpintergiciel.tpintergicielrkpvspring.kafka.KafkaConsumerDynamic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
    @Id
    String nom;

    public Client(){}

    public Client(String nom) {
        this.nom = nom;
    }
    public Client(KafkaConsumer consumer,KafkaConsumerDynamic consumerDynamic,String nom) {
        this.nom=nom;
        consumerDynamic.createConsumer(nom,this);
        consumer.registerClient(this);
    }

    public void receiveMessage(String message) {
        System.out.println("Client " + nom + " received: " + message);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
