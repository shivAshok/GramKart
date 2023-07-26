package com.example.GramKart.Transformer;

import com.example.GramKart.Dto.Request.OrderRequestDto;
import com.example.GramKart.Dto.Response.ItemResponse;
import com.example.GramKart.Dto.Response.OrderResponse;
import com.example.GramKart.Model.Item;
import com.example.GramKart.Model.OrderIntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderTransformer {
    public static OrderIntity OrderRequestToOrder(OrderRequestDto requestDto) {
        OrderIntity orderIntity = OrderIntity.builder().orderId(String.valueOf(UUID.randomUUID()))
                .cardUsed(requestDto.getCardUsed()).build();
        return orderIntity;
    }
    public static OrderResponse OrderToOrderResponse(OrderIntity intity){
        List<Item> items=intity.getItemList();
        List<ItemResponse> itemResponses=new ArrayList<>();
        for(Item i:items){
            itemResponses.add(ItemTransformer.ItemToItemresponse(i));
        }
        int Ordertotal= intity.getOrderTotal();
        OrderResponse response=OrderResponse.builder().customerName(intity.getCustomer().getName())
                .orderTotal(intity.getOrderTotal()).items(itemResponses).cardUsed(intity.getCardUsed()).build();
        return response;
    }
}
