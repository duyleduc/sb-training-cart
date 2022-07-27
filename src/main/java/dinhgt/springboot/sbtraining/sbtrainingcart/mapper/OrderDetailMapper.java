package dinhgt.springboot.sbtraining.sbtrainingcart.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import dinhgt.springboot.sbtraining.sbtrainingcart.dtos.OrderDetailsDTO;
import dinhgt.springboot.sbtraining.sbtrainingcart.model.OrderDetails;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {

	OrderDetailsDTO orderDTO(OrderDetails order);

	OrderDetails orderDAO(OrderDetailsDTO order);

	List<OrderDetailsDTO> listDetailsDTOs(List<OrderDetails> listDetails);
	List<OrderDetails> listDetailsDAOs(List<OrderDetailsDTO> listDetails);
}
