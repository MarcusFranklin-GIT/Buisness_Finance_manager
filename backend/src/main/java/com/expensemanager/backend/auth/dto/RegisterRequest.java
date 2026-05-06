package com.expensemanager.backend.auth.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String name;
    private String phone;
    private String email;
    private String password;
}


// DTO => full form : Data Transfer Object (DTO) is a design pattern used to transfer data between software application subsystems.
