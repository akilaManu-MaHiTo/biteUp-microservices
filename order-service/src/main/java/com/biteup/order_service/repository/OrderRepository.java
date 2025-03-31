package com.biteup.order_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.biteup.order_service.model.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

}
