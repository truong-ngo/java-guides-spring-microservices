package com.javaguides.order.service.mapper;


import com.javaguides.base.dto.OrderDto;
import com.javaguides.order.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityMapper<Order, OrderDto> {
}
