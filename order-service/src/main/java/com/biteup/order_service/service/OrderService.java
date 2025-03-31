package com.biteup.order_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.biteup.order_service.dto.OrderRequestDTO;
import com.biteup.order_service.dto.OrderResponseDTO;
import com.biteup.order_service.httpserver.RestaurantClient;
import com.biteup.order_service.model.Order;
import com.biteup.order_service.repository.OrderRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestaurantClient restaurantClient;

    public OrderResponseDTO placeorders(OrderRequestDTO req) {
        List<Object> restaurantNames = restaurantClient.getAllRestaurants(); // Fetch restaurant names

        Order orders = new Order();
        orders.setOrderNumber(req.getOrderNumber());
        orders.setPrice(req.getPrice());
        orders.setQuantity(req.getQuantity());
        orders.setSkuCode(req.getSkuCode());

        Order saved = orderRepository.save(orders);
        log.info("Order Created Successfully");

        if (saved.getId() == null)
            return new OrderResponseDTO(null, "System Error");

        // Convert restaurantNames to a list of strings
        List<String> restaurantNamesStr = restaurantNames.stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        return new OrderResponseDTO("Order Saved Successfully for: " + String.join(", ", restaurantNamesStr), null);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
