package com.example.GramKart.Repository;

import com.example.GramKart.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
}
