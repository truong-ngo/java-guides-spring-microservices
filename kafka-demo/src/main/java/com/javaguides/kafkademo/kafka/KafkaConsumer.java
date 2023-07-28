package com.javaguides.kafkademo.kafka;

import com.javaguides.kafkademo.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {
    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        log.info("Message receive -> {}", message);
    }

    @KafkaListener(topics = "${spring.kafka.json-topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user) {
        log.info("Message receive -> {}", user);
    }
}
