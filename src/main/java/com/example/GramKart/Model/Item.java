package com.example.GramKart.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name="Itemintity_Table")
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class Item {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    int requiredQuantity;

    @ManyToOne
    @JoinColumn
    Product product;

    @ManyToOne
    @JoinColumn
    OrderIntity orderIntity;

    @ManyToOne
    @JoinColumn
    Cart cart;
}
