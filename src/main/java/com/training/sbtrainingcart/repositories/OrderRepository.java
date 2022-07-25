package com.training.sbtrainingcart.repositories;

import com.training.sbtrainingcart.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order,String> {
    Order findByOrderId(String orderId);


    @Query(value = "SELECT p.quantity FROM product p WHERE p.item_id = :itemId",nativeQuery = true)
    Long getQuantityByItemId(@Param("itemId") String itemId);
}
