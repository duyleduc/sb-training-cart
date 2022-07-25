package com.training.sbtrainingcart.services;

import com.training.sbtrainingcart.entities.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    Order getOrder(String orderId);
    List<Order> getOrders();
    Order updateOrder(String orderId,Order order);
    String removeOrder(String order);
}
