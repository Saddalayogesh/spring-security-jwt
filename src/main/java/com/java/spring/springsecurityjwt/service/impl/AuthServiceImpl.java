package com.java.spring.springsecurityjwt.service.impl;

import com.java.spring.springsecurityjwt.dto.AuthResponseDto;
import com.java.spring.springsecurityjwt.dto.LoginRequestDto;
import com.java.spring.springsecurityjwt.dto.SignupRequestDto;
import com.java.spring.springsecurityjwt.dto.UserResponseDto;
import com.java.spring.springsecurityjwt.entity.User;
import com.java.spring.springsecurityjwt.enums.Role;
import com.java.spring.springsecurityjwt.exception.InvalidCredentialsException;
import com.java.spring.springsecurityjwt.exception.UserExistsException;
import com.java.spring.springsecurityjwt.exception.UserNotFoundException;
import com.java.spring.springsecurityjwt.security.JwtUtil;
import com.java.spring.springsecurityjwt.service.AuthService;
import com.java.spring.springsecurityjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    /*
        LOGIN
     */

    @Override
    public AuthResponseDto login(

            LoginRequestDto loginRequestDto

    ) throws UserNotFoundException,
            InvalidCredentialsException {

        /*
            Find User
         */

        User user =
                userService.findByEmail(
                        loginRequestDto.getEmail()
                );

        /*
            Validate Password
         */

        boolean isValidPassword =
                passwordEncoder.matches(

                        loginRequestDto.getPassword(),

                        user.getPassword()
                );

        if (!isValidPassword) {

            throw new InvalidCredentialsException(
                    "Invalid email or password"
            );
        }

        /*
            Generate Access Token
         */

        String accessToken =
                jwtUtil.generateAccessToken(
                        user
                );

        /*
            Generate Refresh Token
         */

        String refreshToken =
                jwtUtil.generateRefreshToken(
                        user
                );

        /*
            Return Response
         */

        return AuthResponseDto.builder()

                .accessToken(accessToken)

                .refreshToken(refreshToken)

                .user(

                        modelMapper.map(
                                user,
                                UserResponseDto.class
                        )
                )

                .build();
    }

    /*
        SIGNUP
     */

    @Override
    public UserResponseDto signup(

            SignupRequestDto signupRequestDto

    ) throws UserExistsException {

        /*
            Check Existing User
         */

        if (userService.existsByEmail(signupRequestDto.getEmail())) {

            throw new UserExistsException(
                    "User already exists with email : "
                            + signupRequestDto.getEmail()
            );
        }

        /*
            DTO -> ENTITY
         */

        User user =
                modelMapper.map(
                        signupRequestDto,
                        User.class
                );

        /*
            Save User
         */

        return userService.save(user);
    }
}