package com.example.demo;

import java.util.function.Consumer;

import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Lazy(false)
@Component("listenExample")
public class ExampleListener implements Consumer<Message<String>> {

    @PostConstruct
    public void init() {
        System.out.println("ExampleListener created");
    }

    @Override
    public void accept(Message<String> stringMessage) {
        System.out.println(stringMessage.getPayload());
    }
}
