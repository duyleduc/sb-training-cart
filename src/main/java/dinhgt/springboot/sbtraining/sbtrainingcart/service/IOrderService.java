package dinhgt.springboot.sbtraining.sbtrainingcart.service;

import dinhgt.springboot.sbtraining.sbtrainingcart.dtos.OrderDTO;

public interface IOrderService {
	OrderDTO create(OrderDTO order);
}
