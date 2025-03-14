package com.tpintergiciel.tpintergicielrkpvspring.classes;

import jakarta.persistence.*;

@Entity
@Table(name = "msg")
public class Msg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "expediteur")
    String expediteur;
    @Column(name = "receveur")
    String receveur;
    @Column(name = "message")
    String message;

    public Msg(){}

    public Msg(String from, String to, String message) {
        this.expediteur = from;
        this.receveur = to;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public String getReceveur() {
        return receveur;
    }

    public String getMessage() {
        return message;
    }
}
