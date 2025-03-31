package com.biteup.order_service.dto;

import java.math.BigDecimal;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderRequestDTO {

    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
