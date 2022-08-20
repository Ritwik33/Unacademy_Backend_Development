package com.ritwik.KafkaConsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "demo2", groupId = "group_id")
    public void consume(String message) {
        System.out.println("message = " + message);
    }

}
