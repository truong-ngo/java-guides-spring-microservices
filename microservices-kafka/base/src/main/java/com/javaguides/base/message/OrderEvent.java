package com.javaguides.base.message;

import com.javaguides.base.dto.OrderDto;
import com.javaguides.base.enumarate.Status;
import lombok.Data;

@Data
public class OrderEvent {
    private String message;
    private Status status;
    private OrderDto order;
}
