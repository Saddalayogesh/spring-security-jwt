package com.java.spring.springsecurityjwt.service;

import com.java.spring.springsecurityjwt.dto.AuthResponseDto;
import com.java.spring.springsecurityjwt.dto.LoginRequestDto;
import com.java.spring.springsecurityjwt.dto.SignupRequestDto;
import com.java.spring.springsecurityjwt.dto.UserResponseDto;
import com.java.spring.springsecurityjwt.exception.InvalidCredentialsException;
import com.java.spring.springsecurityjwt.exception.UserExistsException;
import com.java.spring.springsecurityjwt.exception.UserNotFoundException;

public interface AuthService {
    AuthResponseDto login(LoginRequestDto loginRequestDto) throws UserNotFoundException, InvalidCredentialsException;
    UserResponseDto signup(SignupRequestDto signupRequestDto) throws UserExistsException;
}
