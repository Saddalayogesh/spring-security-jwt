package com.java.spring.springsecurityjwt.dto;

import com.java.spring.springsecurityjwt.enums.Role;
import lombok.Data;

@Data
public class SignupRequestDto {
    String name;
    String email;
    String password;
    Role role;
}