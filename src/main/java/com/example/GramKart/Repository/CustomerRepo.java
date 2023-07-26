package com.example.GramKart.Repository;

import com.example.GramKart.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    public Optional<Customer> findByEmailId(String emailId);
}
