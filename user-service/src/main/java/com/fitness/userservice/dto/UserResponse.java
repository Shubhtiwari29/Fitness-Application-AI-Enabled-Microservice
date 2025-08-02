package com.fitness.userservice.dto;

import com.fitness.userservice.modal.UserRole;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UserResponse {

    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private UserRole role = UserRole.USER;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
