package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ReceiverService {
    private static final Logger LOGGER = LogManager.getLogger(ReceiverService.class);
    @Autowired
    private MessageRepository messageRepository;

    @PostMapping(value = "/messages", consumes = "application/json", produces = "application/json")
    public Message receive(@RequestBody Message message) {
        LOGGER.info("received\t" + message);
        messageRepository.saveAndFlush(message);
        return new Message(new Date().toString(), "received\t" + message.getMessage());
    }
}
