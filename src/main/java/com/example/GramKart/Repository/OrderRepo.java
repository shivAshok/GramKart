package com.example.GramKart.Repository;

import com.example.GramKart.Model.OrderIntity;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderIntity,Integer> {
}
