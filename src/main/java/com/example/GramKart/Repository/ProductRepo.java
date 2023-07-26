package com.example.GramKart.Repository;

import com.example.GramKart.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
