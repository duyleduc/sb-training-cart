package dinhgt.springboot.sbtraining.sbtrainingcart.service;

import java.util.List;

import dinhgt.springboot.sbtraining.sbtrainingcart.dtos.OrderDTO;
import dinhgt.springboot.sbtraining.sbtrainingcart.dtos.OrderDetailsDTO;

public interface IOrderDetailsService {

	List<OrderDetailsDTO> saveAllOrderDetails(List<OrderDetailsDTO> listDetails, OrderDTO id);
	
}
