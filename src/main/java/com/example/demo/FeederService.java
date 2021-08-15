package com.example.demo;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class FeederService {
    private static final String URL = "https://localhost:8080/messages";

    @Scheduled(fixedRate = 5000)
    public void send() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", new Date().toString());
        jsonObject.put("message", "Hello world!");
        HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), httpHeaders);
        restTemplate.postForObject(URL, request, String.class);
        System.out.println("Sent out " + jsonObject);
    }
}
