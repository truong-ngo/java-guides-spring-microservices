package com.javaguide.restapi.service.impl;

import com.javaguide.restapi.dto.UserDTO;
import com.javaguide.restapi.entity.User;
import com.javaguide.restapi.exception.BusinessException;
import com.javaguide.restapi.repository.UserRepo;
import com.javaguide.restapi.service.core.UserService;
import com.javaguide.restapi.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> findAll() {
        log.info("Request to get all user: ");
        return userRepo.findAll().stream().map(userMapper::toDto).toList();
    }

    @Override
    public UserDTO findById(Long id) {
        log.info("Request to get user by id: {}", id);
        User user = userRepo.findById(id).orElseThrow(() -> new BusinessException("userNotFound"));
        return userMapper.toDto(user);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        log.info("Request to save user: {}", userDTO);
        return userMapper.toDto(userRepo.save(userMapper.toEntity(userDTO)));
    }

    @Override
    public void delete(Long id) {
        log.info("Request to delete user: {}", id);
        userRepo.deleteById(id);
    }
}
