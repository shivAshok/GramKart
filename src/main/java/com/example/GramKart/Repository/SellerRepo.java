package com.example.GramKart.Repository;

import com.example.GramKart.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepo extends JpaRepository<Seller,Integer> {
}
