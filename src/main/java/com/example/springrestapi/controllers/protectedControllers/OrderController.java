package com.example.springrestapi.controllers.protectedControllers;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrestapi.configurations.RequestConfig;
import com.example.springrestapi.models.EditOrderDto;
import com.example.springrestapi.models.OrderDto;
import com.example.springrestapi.responseBodies.AllOrderResponse;
import com.example.springrestapi.responseBodies.SingleOrderResponse;
import com.example.springrestapi.services.interfaces.OrderService;
import com.example.springrestapi.utils.RestTemplateUtil;

@RestController
@RequestMapping(RequestConfig.BASE_PROTECTED_URL + "/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    RestTemplateUtil restTemplateUtil;

    @GetMapping
    public ResponseEntity<List<AllOrderResponse>> getOrders(HttpServletRequest request) throws Exception {
        restTemplateUtil.authVerify(request, RequestConfig.AUTH_URL + "/verify/admin");
        List<AllOrderResponse> response = orderService.getOrders();
        return new ResponseEntity<List<AllOrderResponse>>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SingleOrderResponse> createOrder(@Valid @RequestBody OrderDto body,
            HttpServletRequest request) throws Exception {
        restTemplateUtil.authVerify(request, RequestConfig.AUTH_URL + "/verify/admin");
        SingleOrderResponse response = orderService.createOrder(body);
        return new ResponseEntity<SingleOrderResponse>(response, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SingleOrderResponse> editOrder(@Valid @RequestBody EditOrderDto body,
            @PathVariable(value = "id") UUID id, HttpServletRequest request) throws Exception {
        restTemplateUtil.authVerify(request, RequestConfig.AUTH_URL + "/verify/admin");

        SingleOrderResponse response = orderService.editOrder(body, id);
        return new ResponseEntity<SingleOrderResponse>(response, HttpStatus.OK);
    }

}
