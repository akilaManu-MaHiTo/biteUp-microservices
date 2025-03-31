package com.biteup.order_service.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
