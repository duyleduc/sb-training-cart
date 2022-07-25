package com.example.springrestapi.messages;

import org.springframework.stereotype.Component;

@Component
public class MessageBuilder {
    public static QueueMessage buildMessage(Object data, String queueName, String routingKey, String topicName) {
        return new QueueMessage(data, routingKey, topicName, queueName);
    }
}
