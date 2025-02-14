package com.tpintergiciel.tpintergicielrkpvspring;

public class Message {
    private String message;
    private String type;

    public Message(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }
    public String getType() {
        return type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(String type) {
        this.type = type;
    }
}
