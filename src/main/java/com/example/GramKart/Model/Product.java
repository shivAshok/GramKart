package com.example.GramKart.Model;

import com.example.GramKart.Enums.ProductCategory;
import com.example.GramKart.Enums.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name="product_Table")
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int p_id;

    String productName;

    int availableQuantity;

    int price;

    @Enumerated(EnumType.STRING)
    ProductCategory category;
    @Enumerated(EnumType.STRING)
    ProductStatus status;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Item> itemList=new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Seller seller;
}
