package com.sisipapa.orderservice.service;

import com.sisipapa.orderservice.dto.OrderDto;
import com.sisipapa.orderservice.jpa.OrderEntity;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
    OrderDto getOrderByOrderId(String orderId);
    Iterable<OrderEntity> getOrdersByUserId(String userId);
}
