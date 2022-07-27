package dinhgt.springboot.sbtraining.sbtrainingcart.interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dinhgt.springboot.sbtraining.sbtrainingcart.model.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, UUID> {

}
