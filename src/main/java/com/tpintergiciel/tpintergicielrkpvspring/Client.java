package com.tpintergiciel.tpintergicielrkpvspring;

public class Client {
    String nom;

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
