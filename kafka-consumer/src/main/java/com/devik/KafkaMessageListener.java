package com.devik;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaMessageListener {

    @KafkaListener(topics = "topic-1",
            groupId = "group-1")
    public void listener(String data) {
        System.out.println("Date received:" + data);
    }
}
