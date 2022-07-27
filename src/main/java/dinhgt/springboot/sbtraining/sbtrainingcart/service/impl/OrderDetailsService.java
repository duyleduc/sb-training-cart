package dinhgt.springboot.sbtraining.sbtrainingcart.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dinhgt.springboot.sbtraining.sbtrainingcart.dtos.OrderDTO;
import dinhgt.springboot.sbtraining.sbtrainingcart.dtos.OrderDetailsDTO;
import dinhgt.springboot.sbtraining.sbtrainingcart.interfaces.OrderDetailsRepository;
import dinhgt.springboot.sbtraining.sbtrainingcart.model.OrderDetails;
import dinhgt.springboot.sbtraining.sbtrainingcart.service.IOrderDetailsService;

@Service
public class OrderDetailsService implements IOrderDetailsService {

	@Autowired
	private ModelMapper detailMapper;

	@Autowired
	private OrderDetailsRepository detailsRepository;

	@Override
	public List<OrderDetailsDTO> saveAllOrderDetails(List<OrderDetailsDTO> listDetails, OrderDTO order) {
		List<OrderDetails> listDetailsDAO = new ArrayList<>();
		for (OrderDetailsDTO orderDetailsDTO : listDetails) {
			orderDetailsDTO.setCreatedDate(LocalDateTime.now());
			orderDetailsDTO.setOrders(order);

			listDetailsDAO.add(detailMapper.map(orderDetailsDTO, OrderDetails.class));
		}

		List<OrderDetails> listResult = detailsRepository.saveAll(listDetailsDAO);
		List<OrderDetailsDTO> listResultDTO = new ArrayList<>();
		for (OrderDetails orderDetails : listResult) {

			listResultDTO.add(detailMapper.map(orderDetails, OrderDetailsDTO.class));
		}

		return listResultDTO;
	}

}
