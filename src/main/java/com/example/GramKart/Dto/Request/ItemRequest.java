package com.example.GramKart.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {
    int requiredQuant;
    int productId;
    int customerId;
}
