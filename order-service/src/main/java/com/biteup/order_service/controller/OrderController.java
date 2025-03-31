package com.biteup.order_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biteup.order_service.dto.OrderRequestDTO;
import com.biteup.order_service.dto.OrderResponseDTO;
import com.biteup.order_service.model.Order;
import com.biteup.order_service.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @PostMapping
    public ResponseEntity<OrderResponseDTO> createProducts(
        @RequestBody OrderRequestDTO req
    ) {
        OrderResponseDTO res = orderService.placeorders(req);
        if(res.getError() != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        }
    }

    @GetMapping
    public List<Order> getAllProducts(){
        return orderService.getAllOrders();
    }
    
}
