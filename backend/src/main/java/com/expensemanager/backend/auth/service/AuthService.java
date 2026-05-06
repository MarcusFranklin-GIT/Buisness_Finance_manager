package com.expensemanager.backend.auth.service;

import java.util.Date;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.expensemanager.backend.auth.dto.RegisterRequest;
import com.expensemanager.backend.auth.model.Dealer;
import com.expensemanager.backend.auth.repository.DealerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final DealerRepository dealerRepository;            //this is a reference to the DealerRepository interface, which is used to interact with the database for CRUD operations related to the Dealer entity.
    private final PasswordEncoder passwordEncoder;              //this is a object of the PasswordEncoder interface, which is used to encode passwords before storing them in the database.

    public void register(RegisterRequest request) {

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
    }
}