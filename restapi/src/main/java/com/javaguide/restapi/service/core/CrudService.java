package com.javaguide.restapi.service.core;

public interface CrudService<E, ID> {
    E findById(ID id);
    E save(E e);
    void delete(ID id);
}
