package com.example.GramKart.Dto.Response;

import com.example.GramKart.Enums.ProductCategory;
import com.example.GramKart.Enums.ProductStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    String productName;

    int availableQuantity;

    int price;


    ProductCategory category;

    ProductStatus status;

    String sellerName;
}
