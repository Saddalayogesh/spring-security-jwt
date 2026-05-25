package com.java.spring.springsecurityjwt.dto;

import com.java.spring.springsecurityjwt.enums.Role;
import lombok.Data;

@Data
public class UserResponseDto {

    Integer id;

    String name;

    String email;

    Role role;

}
