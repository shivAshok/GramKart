package com.example.GramKart.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemResponse {
    String customerName;
    int cartTotal;
    String productName;
    String sellerName;
    int price;
}
