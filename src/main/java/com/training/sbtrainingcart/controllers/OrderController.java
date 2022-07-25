package com.training.sbtrainingcart.controllers;

import com.training.sbtrainingcart.entities.Order;
import com.training.sbtrainingcart.models.CreateOrderDto;
import com.training.sbtrainingcart.models.UpdateOrderDto;
import com.training.sbtrainingcart.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/protected/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<CreateOrderDto> getOrders(){
        List<Order> orders = orderService.getOrders();

        return orders.stream().map(order -> modelMapper.map(order, CreateOrderDto.class)).collect(Collectors.toList());
    }

    @GetMapping("{orderId}")
    public CreateOrderDto getOrder(@PathVariable String orderId){
        Order order = orderService.getOrder(orderId);
        return modelMapper.map(order, CreateOrderDto.class);
    }

    @PostMapping
    public CreateOrderDto saveOrder(@RequestBody CreateOrderDto createOrderDto) {

        Order order = modelMapper.map(createOrderDto,Order.class);

        Order savedOrder = orderService.saveOrder(order);

        return modelMapper.map(savedOrder, CreateOrderDto.class);
    }

    @PutMapping("{orderId}")
    public CreateOrderDto updateOrder(@RequestBody UpdateOrderDto updateOrderDto, @PathVariable String orderId){

        Order order = modelMapper.map(updateOrderDto,Order.class);

        Order result = orderService.updateOrder(orderId,order);

        return modelMapper.map(result, CreateOrderDto.class);
    }
}
