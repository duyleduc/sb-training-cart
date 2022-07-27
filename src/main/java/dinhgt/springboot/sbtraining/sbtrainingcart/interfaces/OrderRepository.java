package dinhgt.springboot.sbtraining.sbtrainingcart.interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dinhgt.springboot.sbtraining.sbtrainingcart.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

}
