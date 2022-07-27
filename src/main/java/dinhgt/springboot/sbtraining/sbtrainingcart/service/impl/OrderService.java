package dinhgt.springboot.sbtraining.sbtrainingcart.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dinhgt.springboot.sbtraining.sbtrainingcart.dtos.ItemDTO;
import dinhgt.springboot.sbtraining.sbtrainingcart.dtos.OrderDTO;
import dinhgt.springboot.sbtraining.sbtrainingcart.dtos.OrderDetailsDTO;
import dinhgt.springboot.sbtraining.sbtrainingcart.exception.OrderCreateException;
import dinhgt.springboot.sbtraining.sbtrainingcart.interfaces.OrderRepository;
import dinhgt.springboot.sbtraining.sbtrainingcart.model.Order;
import dinhgt.springboot.sbtraining.sbtrainingcart.service.IOrderDetailsService;
import dinhgt.springboot.sbtraining.sbtrainingcart.service.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ModelMapper orderMapper;

	@Autowired
	private IOrderDetailsService detailsService;

	@Autowired
	private RestTemplate restTemplate;

	public void checkQuantity(List<OrderDetailsDTO> listOrderDetails) {
		for (OrderDetailsDTO orderDetailsDTO : listOrderDetails) {
			ResponseEntity<ItemDTO> item = restTemplate.getForEntity(
					"http://catalogs-service/api/v1/public/item/" + listOrderDetails.get(0).getItemID(),
					ItemDTO.class);
			if (Integer.compare(orderDetailsDTO.getQuantity(), item.getBody().getQuantity()) > 0) {
				throw new OrderCreateException("Sản phẩm " + orderDetailsDTO.getItemID() + " không đủ số lượng");
			}
		}
	}

	@Override
	@Transactional
	public OrderDTO create(OrderDTO order) {

		Order tempDAO = orderMapper.map(order, Order.class);
		tempDAO.setCreatedDate(LocalDateTime.now());

		Order orderDAO = orderRepository.saveAndFlush(tempDAO);
		OrderDTO result = orderMapper.map(orderDAO, OrderDTO.class);
		result.setListOrderDetails(detailsService.saveAllOrderDetails(result.getListOrderDetails(), result));

		for (OrderDetailsDTO orderDetailsDTO : result.getListOrderDetails()) {
			try {
			restTemplate.put("http://catalogs-service/api/v1/public/item/itemID/" +"CA000",
					new ItemDTO("CA000", orderDetailsDTO.getQuantity()));
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
				throw new OrderCreateException(ex.getMessage());
			}
		}
		return result;
	}

}
