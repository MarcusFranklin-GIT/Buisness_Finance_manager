package com.expensemanager.backend.auth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.expensemanager.backend.auth.model.Dealer;

public interface DealerRepository extends MongoRepository<Dealer , String>{
    Optional<Dealer> findByPhine(String phone);
}