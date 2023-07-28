package com.example.consumer.kafka;

import com.example.consumer.entity.Wikimedia;
import com.example.consumer.repository.WikimediaRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final WikimediaRepo wikimediaRepo;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        log.info("Message receive: {}", message);
        Wikimedia wikimedia = new Wikimedia();
        wikimedia.setData(message.getBytes());
        wikimediaRepo.save(wikimedia);
        log.info("Message save");
    }
}
