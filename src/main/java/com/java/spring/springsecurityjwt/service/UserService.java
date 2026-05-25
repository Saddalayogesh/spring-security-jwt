package com.java.spring.springsecurityjwt.service;

import com.java.spring.springsecurityjwt.dto.UserResponseDto;
import com.java.spring.springsecurityjwt.entity.User;
import com.java.spring.springsecurityjwt.exception.UserNotFoundException;

public interface UserService {
    UserResponseDto save(User user) throws UserNotFoundException;
    User findByEmail(String email) throws UserNotFoundException;
    boolean existsByEmail(String email);
}