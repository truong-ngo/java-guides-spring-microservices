package com.javaguides.order.service.core;

import com.javaguides.base.dto.OrderDto;

public interface OrderService extends CrudService<OrderDto, String> {
    OrderDto placeOrder(OrderDto orderDto);
}
