package com.tpintergiciel.tpintergicielrkpvspring.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "msg")
public class Msg {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "expediteur")
    String expediteur;
    @Column(name = "receveur")
    String receveur;
    @Column(name = "message")
    String message;

    public Msg(){}

    public Msg(int id, String from, String to, String message) {

        this.id = id;
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
