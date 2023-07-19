package com.microservices.employee.service.core;

public interface CrudService<E, ID> {
    E findById(ID id);
    E save(E e);
    void delete(ID id);
}
