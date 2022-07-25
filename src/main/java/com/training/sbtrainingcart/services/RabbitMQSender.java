package com.training.sbtrainingcart.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.sbtrainingcart.config.RabbitMQConfig;
import com.training.sbtrainingcart.entities.Order;
import com.training.sbtrainingcart.entities.OrderDetail;
import com.training.sbtrainingcart.models.CustomMessage;
import com.training.sbtrainingcart.models.TestMessage;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${mq.rabbitmq.queue}")
    private String queueName;

    @Autowired
    private ObjectMapper objectMapper;

    public void send(TestMessage order) {
    try {
        String orderJson = objectMapper.writeValueAsString(order);

        Message message = MessageBuilder.withBody(orderJson.getBytes()).setContentType(MessageProperties.CONTENT_TYPE_JSON).build();

        rabbitTemplate.convertAndSend(queueName, message);


    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }

    }
}
