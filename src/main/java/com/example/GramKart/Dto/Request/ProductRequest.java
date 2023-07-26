package com.example.GramKart.Dto.Request;

import com.example.GramKart.Enums.ProductCategory;
import com.example.GramKart.Enums.ProductStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    String productName;

    int availableQuantity;

    int price;

    ProductCategory category;

    int sellerId;
}
