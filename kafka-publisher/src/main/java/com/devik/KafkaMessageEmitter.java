package com.devik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Date;
import java.util.zip.DataFormatException;

@Component
public class KafkaMessageEmitter implements ListenableFutureCallback<SendResult<String, String>> {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Scheduled(fixedDelay = 1000)
    private void emitRandomMessage(){
        kafkaTemplate
                .send("topic-1","Hello at "+new Date())
                .addCallback(this);
    }

    @Override
    public void onFailure(Throwable ex) {
        System.out.println("Message failed:"+ex.getMessage());
    }

    @Override
    public void onSuccess(SendResult<String, String> result) {
        System.out.println("Successfully sent message:"+result.getProducerRecord().value());
    }
}
