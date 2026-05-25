package com.java.spring.springsecurityjwt.controller;


import com.java.spring.springsecurityjwt.dto.UserResponseDto;
import com.java.spring.springsecurityjwt.entity.User;
import com.java.spring.springsecurityjwt.exception.UserNotFoundException;
import com.java.spring.springsecurityjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/users")

@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;

    /*
        GET USER BY EMAIL
     */

    @GetMapping("/email/{email}")

    public ResponseEntity<UserResponseDto>
    getByEmail(

            @PathVariable
            String email

    ) throws UserNotFoundException {

        User user =
                userService.findByEmail(
                        email
                );

        UserResponseDto userDto =
                modelMapper.map(
                        user,
                        UserResponseDto.class
                );

        return ResponseEntity.ok(
                userDto
        );
    }
}