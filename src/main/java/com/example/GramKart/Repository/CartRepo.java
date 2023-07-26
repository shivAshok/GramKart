package com.example.GramKart.Repository;

import com.example.GramKart.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart,Integer> {
}
