package com.example.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Lazy(false)
@Component
public class ExampleProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private int counter = 1;

    public ExampleProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        System.out.println("ExampleProducer created");
    }

    @Scheduled(fixedDelay = 1000)
    void sendExampleMessages() {
        kafkaTemplate.send("example-topic", "Recieved message " + counter);
        System.out.println("Sent message " + counter++);
    }
}
