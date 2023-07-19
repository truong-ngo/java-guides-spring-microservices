package com.javaguide.restapi.service.mapper;

import com.javaguide.restapi.dto.UserDTO;
import com.javaguide.restapi.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<User, UserDTO> {
}
