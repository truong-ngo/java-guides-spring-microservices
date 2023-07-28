package com.javaguides.order.service.impl;

import com.javaguides.base.dto.OrderDto;
import com.javaguides.base.enumarate.Status;
import com.javaguides.base.message.OrderEvent;
import com.javaguides.order.repository.OrderRepo;
import com.javaguides.order.service.core.OrderService;
import com.javaguides.order.service.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;
    private final OrderProducer orderProducer;

    @Override
    public OrderDto findById(String id) {
        log.info("Request to get order with id: {}", id);
        return orderMapper.toDto(orderRepo.findById(id).orElse(null));
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        log.info("Request to get save order: {}", orderDto);
        return orderMapper.toDto(orderRepo.save(orderMapper.toEntity(orderDto)));
    }

    @Override
    public void delete(String id) {
        log.info("Request to get delete order with id: {}", id);
        orderRepo.deleteById(id);
    }

    @Override
    public OrderDto placeOrder(OrderDto orderDto) {
        orderDto = save(orderDto);
        OrderEvent event = new OrderEvent();
        event.setStatus(Status.SUCCESS);
        event.setMessage("Place order with id: " + orderDto.getId());
        event.setOrder(orderDto);
        orderProducer.sendMessage(event);
        return orderDto;
    }
}
