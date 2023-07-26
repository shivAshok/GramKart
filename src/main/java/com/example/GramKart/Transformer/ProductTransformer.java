package com.example.GramKart.Transformer;

import com.example.GramKart.Dto.Request.ProductRequest;
import com.example.GramKart.Dto.Response.ProductResponse;
import com.example.GramKart.Model.Product;

public class ProductTransformer {
    public static Product ProductRequesttoProduct(ProductRequest request){
        Product p=Product.builder().productName(request.getProductName()).availableQuantity(request.getAvailableQuantity())
                .price(request.getPrice()).category(request.getCategory()).build();
        return p;
    }

    public static ProductResponse ProductToproductResponse(Product p){
        ProductResponse response=ProductResponse.builder().productName(p.getProductName())
                .availableQuantity(p.getAvailableQuantity()).price(p.getPrice())
                .category(p.getCategory())
                .status(p.getStatus()).sellerName(p.getSeller().getName()).build();
        return response;
    }
}
