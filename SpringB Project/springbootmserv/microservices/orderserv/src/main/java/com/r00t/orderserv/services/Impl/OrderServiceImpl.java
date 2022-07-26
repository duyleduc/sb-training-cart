package com.r00t.orderserv.services.Impl;

import java.util.List;

import com.r00t.orderserv.models.DTO.OrdersDTO;

public interface OrderServiceImpl {
    OrdersDTO getOrder(String orderID) throws Exception;

    List<OrdersDTO> getAllOrders() throws Exception;

    OrdersDTO createOrder(OrdersDTO order) throws Exception;

    OrdersDTO updateOrder(OrdersDTO order) throws Exception;

    
}
