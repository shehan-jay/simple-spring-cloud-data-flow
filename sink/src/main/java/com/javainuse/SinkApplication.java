package com.javainuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

@SpringBootApplication
public class SinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinkApplication.class, args);
    }

    // Define a MessageHandlerMethodFactory bean
    @Bean
    public MessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        // Customize the factory if needed
        // e.g., factory.setValidator(validator());
        return factory;
    }

    // Define a service activator method
    @ServiceActivator(inputChannel = "input")
    public void handleMessage(Message<String> message) {
        // Handle the incoming message
        System.out.println("Received message: " + message.getPayload());
    }

    // Other methods and configurations can go here

}
