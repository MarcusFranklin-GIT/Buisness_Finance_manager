package com.expensemanager.backend.auth.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String name;
    private String phone;
    private String email;
    private String password;
}


// DTO => full form : District Transport Office