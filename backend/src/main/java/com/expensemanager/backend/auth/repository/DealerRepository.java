package com.expensemanager.backend.auth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.expensemanager.backend.auth.model.Dealer;

public interface DealerRepository extends MongoRepository<Dealer , String>{
    Optional<Dealer> findByPhine(String phone);
}

// The DealerRepository interface extends MongoRepository, providing CRUD operations for the Dealer entity. It also includes a custom method findByPhone to retrieve a Dealer by their phone number.