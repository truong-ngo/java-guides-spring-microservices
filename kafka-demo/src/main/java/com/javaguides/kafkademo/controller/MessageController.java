package com.javaguides.kafkademo.controller;

import com.javaguides.kafkademo.kafka.JsonKafkaProducer;
import com.javaguides.kafkademo.kafka.KafkaProducer;
import com.javaguides.kafkademo.payload.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaProducer kafkaProducer;
    private final JsonKafkaProducer jsonKafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message send to topic");
    }

    @PostMapping("/publish/user")
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message send to topic");
    }
}
