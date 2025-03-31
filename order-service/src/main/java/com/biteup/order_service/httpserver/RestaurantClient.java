package com.biteup.order_service.httpserver;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "restaurant", url = "http://localhost:8082")
public interface RestaurantClient {

    @GetMapping("/api/restaurant")  // Replace @RequestMapping with @GetMapping
    List<Object> getAllRestaurants();
}
