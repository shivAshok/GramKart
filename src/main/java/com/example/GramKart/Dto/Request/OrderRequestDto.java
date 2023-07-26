package com.example.GramKart.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
    String customerEmail;

    int productId;

    String cardUsed;

    int cvv;

    int requiredQuantity;
}
