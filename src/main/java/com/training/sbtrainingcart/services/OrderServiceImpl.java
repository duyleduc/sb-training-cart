package com.training.sbtrainingcart.services;

import com.training.sbtrainingcart.entities.Order;
import com.training.sbtrainingcart.exceptions.QuantityIsLargerThanItemInWareHouse;
import com.training.sbtrainingcart.exceptions.ResourceNotFoundException;
import com.training.sbtrainingcart.models.CustomMessage;
import com.training.sbtrainingcart.models.TestMessage;
import com.training.sbtrainingcart.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    @Transactional
    public Order saveOrder(Order order) {

        Long quantity = orderRepository.getQuantityByItemId(order.getOrderDetail().getItemId());

        if(order.getOrderDetail().getQuantity() > quantity){
            throw new QuantityIsLargerThanItemInWareHouse();
        }

        Order savedOrder = orderRepository.save(order);

        TestMessage message = new TestMessage(savedOrder.getOrderDetail().getItemId(),savedOrder.getOrderDetail().getQuantity());

        rabbitMQSender.send(message);

        return savedOrder;
    }

    @Override
    public Order getOrder(String orderId) {

        Order order = orderRepository.findByOrderId(orderId);
        if(order == null){
            throw new ResourceNotFoundException("Order","order Id",orderId);
        }

        return  order;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public Order updateOrder(String orderId, Order order) {

        Order orderDB = orderRepository.findByOrderId(orderId);
        if(orderDB == null){
            throw new ResourceNotFoundException("Order","order Id",orderId);
        }


        orderDB.getOrderDetail().setStatus(order.getOrderDetail().getStatus());
        orderDB.setComment(order.getComment());
        orderDB.getOrderDetail().setModifiedDate(LocalDateTime.now());

        return orderRepository.save(orderDB);
    }

    @Override
    @Transactional
    public String removeOrder(String order) {
        return null;
    }
}
