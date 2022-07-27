package com.example.springrestapi.controllers.publicControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrestapi.configurations.RequestConfig;
import com.example.springrestapi.publishers.Publisher;

@RestController
@RequestMapping(value = RequestConfig.BASE_PUBLIC_URL + "/rabbitMQ")
public class RabbitMQController {

    @Autowired
    private Publisher verifyPublisher;

    @PostMapping
    public void testSendMessage() {

    }
}
