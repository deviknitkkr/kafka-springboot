package com.devik.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaPublisherTopics {

    @Bean
    public NewTopic newTopic1() {
        return TopicBuilder
                .name("topic-1")
                .build();
    }
}
