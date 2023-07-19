package com.javaguide.restapi.service.core;

import com.javaguide.restapi.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO, Long> {
    List<UserDTO> findAll();
}
