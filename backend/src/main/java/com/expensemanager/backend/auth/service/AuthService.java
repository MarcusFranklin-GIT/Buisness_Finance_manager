package com.expensemanager.backend.auth.service;

import com.expensemanager.backend.auth.dto.LoginRequest;
import com.expensemanager.backend.auth.dto.LoginResponse;
import com.expensemanager.backend.auth.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);

    LoginResponse login(LoginRequest request);
}