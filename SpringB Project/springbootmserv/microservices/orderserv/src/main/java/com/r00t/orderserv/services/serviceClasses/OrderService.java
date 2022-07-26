package com.r00t.orderserv.services.serviceClasses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r00t.orderserv.mappers.OrderDetailsMapper;
import com.r00t.orderserv.mappers.OrdersMapper;
import com.r00t.orderserv.models.DTO.OrderDetailsDTO;
import com.r00t.orderserv.models.DTO.OrdersDTO;
import com.r00t.orderserv.repositories.OrderDetailsRepository;
import com.r00t.orderserv.repositories.OrdersRepository;
import com.r00t.orderserv.services.Impl.DetailServiceImpl;
import com.r00t.orderserv.services.Impl.OrderServiceImpl;

@Service
public class OrderService implements OrderServiceImpl, DetailServiceImpl {
    @Autowired
    OrdersMapper oMapper;
    @Autowired
    OrdersRepository oRepository;
    @Autowired
    OrderDetailsMapper dMapper;
    @Autowired
    OrderDetailsRepository dRepository;
    
    @Override
    public OrderDetailsDTO getDetail(String detailID) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<OrderDetailsDTO> getAllDetails(String orderID) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public OrderDetailsDTO createDetail(String orderID, OrderDetailsDTO detail) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public OrderDetailsDTO updateDetails(String status) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public OrdersDTO getOrder(String orderID) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<OrdersDTO> getAllOrders() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public OrdersDTO createOrder(OrdersDTO order) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public OrdersDTO updateOrder(OrdersDTO order) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
}
