package com.expensemanager.backend.auth.service.impl;

import java.util.Date;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.expensemanager.backend.auth.dto.RegisterRequest;
import com.expensemanager.backend.auth.entity.Dealer;
import com.expensemanager.backend.auth.repository.DealerRepository;
import com.expensemanager.backend.auth.service.AuthService;
import com.expensemanager.backend.auth.dto.LoginRequest;
import com.expensemanager.backend.auth.dto.LoginResponse;
import com.expensemanager.backend.auth.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final DealerRepository dealerRepository;            //this is a reference to the DealerRepository interface, which is used to interact with the database for CRUD operations related to the Dealer entity.
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;        //this is a object of the JwtService class, which is used to generate and validate JWT tokens.

    @Override
    public String register(RegisterRequest request) {

        // check duplicate phone
        if (dealerRepository.findByPhone(request.getPhone()).isPresent()) {
            throw new RuntimeException("Phone already exists");
        }

        Dealer dealer = new Dealer();

        dealer.setName(request.getName());
        dealer.setPhone(request.getPhone());
        dealer.setEmail(request.getEmail());
        dealer.setPassword(passwordEncoder.encode(request.getPassword()));
        dealer.setCreatedAt(new Date());

        dealerRepository.save(dealer);

        return "Dealer Registered Successfully";
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        Dealer dealer = dealerRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid Email"));

        boolean isPasswordCorrect = passwordEncoder.matches(
                request.getPassword(),
                dealer.getPassword()
        );

        if (!isPasswordCorrect) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtService.generateToken(dealer.getEmail());

        return new LoginResponse(token);
    }
}
