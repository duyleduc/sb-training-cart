package com.r00t.orderserv.services.Impl;

import java.util.List;

import com.r00t.orderserv.models.DTO.OrderDetailsDTO;

public interface DetailServiceImpl {
    OrderDetailsDTO getDetail(String detailID) throws Exception;

    List<OrderDetailsDTO> getAllDetails(String orderID) throws Exception;

    OrderDetailsDTO createDetail(String orderID, OrderDetailsDTO detail) throws Exception;

    OrderDetailsDTO updateDetails(String status) throws Exception;
}
