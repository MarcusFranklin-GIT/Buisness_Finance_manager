package com.expensemanager.backend.auth.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection = "dealers")

public class Dealer{
    
    @Id
    private String id;

    private String name;

    @Indexed(unique = true)
    private String phone;

    @Indexed(unique = true,sparse = true)
    private String email;

    private String password;

    private Date createdAt;



}

// this is a Java class named Dealer that represents a dealer entity in the application. It is annotated with @Document to indicate that it is a MongoDB document, and it contains fields for id, name, phone, email, password, and createdAt. The phone and email fields are indexed and marked as unique to ensure that there are no duplicate entries in the database.
//sparse = true => This is used to create a sparse index on the email field, which allows for null values in the email field while still enforcing uniqueness for non-null values.
