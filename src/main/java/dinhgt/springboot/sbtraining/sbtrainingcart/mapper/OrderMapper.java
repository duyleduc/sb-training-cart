package dinhgt.springboot.sbtraining.sbtrainingcart.mapper;

import org.mapstruct.Mapper;

import dinhgt.springboot.sbtraining.sbtrainingcart.dtos.OrderDTO;
import dinhgt.springboot.sbtraining.sbtrainingcart.model.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

	OrderDTO orderDTO(Order order);

	Order orderDAO(OrderDTO order);
}
