package com.javaguides.kafkademo.kafka;

import com.javaguides.kafkademo.payload.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JsonKafkaProducer {
    private final KafkaTemplate<String, User> kafkaTemplate;

    @Value("${spring.kafka.json-topic.name}")
    private String jsonTopicName;

    public void sendMessage(User data) {
        log.info("Send message: {}", data);
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, jsonTopicName)
                .build();
        kafkaTemplate.send(message);
    }
}
