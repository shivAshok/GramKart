package com.example.GramKart.Transformer;

import com.example.GramKart.Dto.Request.ItemRequest;
import com.example.GramKart.Dto.Response.ItemResponse;
import com.example.GramKart.Model.Item;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemTransformer {
    @Autowired

    public static Item IItemRequestToItem(ItemRequest request){
        Item item=Item.builder().requiredQuantity(request.getRequiredQuant()).build();
        return item;
    }
    public static ItemResponse ItemToItemresponse(Item item){
        ItemResponse response=ItemResponse.builder()
                .productName(item.getProduct().getProductName()).
                sellerName(item.getProduct().getSeller().getName()).price(item.getProduct().getPrice())
                 .build();
        if(item.getProduct()==null){
            response.setCustomerName(item.getCart().getCustomer().getName());
            response.setCartTotal(item.getCart().getCartTotal());
        }
        return response;
    }
}
