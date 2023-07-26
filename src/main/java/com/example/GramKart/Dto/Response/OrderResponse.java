package com.example.GramKart.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    String customerName;

    String orderId;

    String cardUsed;

    //int cvv;

    int orderTotal;

    List<ItemResponse> items;
}
