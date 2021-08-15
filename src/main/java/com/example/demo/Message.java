package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    private String id;
    @Column
    private String message;

    private Message() {
    }

    public Message(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return this.id + '\t' + this.message;
    }
}
