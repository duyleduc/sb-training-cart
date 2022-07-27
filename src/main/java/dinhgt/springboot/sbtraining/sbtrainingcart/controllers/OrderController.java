package dinhgt.springboot.sbtraining.sbtrainingcart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dinhgt.springboot.sbtraining.sbtrainingcart.dtos.OrderDTO;
import dinhgt.springboot.sbtraining.sbtrainingcart.service.IOrderService;

@RestController
@RequestMapping("/api/v1/protected/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@PostMapping("")

	public OrderDTO create(@RequestBody OrderDTO orders) {

		return orderService.create(orders);
	}

}
