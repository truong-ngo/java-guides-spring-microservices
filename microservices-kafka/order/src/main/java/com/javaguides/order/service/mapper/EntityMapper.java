package com.javaguides.order.service.mapper;

public interface EntityMapper<E, D> {
    E toEntity(D dto);
    D toDto(E e);
}
