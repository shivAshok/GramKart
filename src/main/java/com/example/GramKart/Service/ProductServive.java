package com.example.GramKart.Service;

import com.example.GramKart.Dto.Request.ProductRequest;
import com.example.GramKart.Dto.Response.ProductResponse;
import com.example.GramKart.Enums.ProductStatus;
import com.example.GramKart.Exception.SellerNotPresent;
import com.example.GramKart.Model.Product;
import com.example.GramKart.Model.Seller;
import com.example.GramKart.Repository.ProductRepo;
import com.example.GramKart.Repository.SellerRepo;
import com.example.GramKart.Transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductServive {
    @Autowired
    ProductRepo productRepo;

    @Autowired
    SellerRepo sellerRepo;
    public ProductResponse addProduct(ProductRequest request) {
        Optional<Seller> s=sellerRepo.findById(request.getSellerId());
        if(s.isEmpty()){
            throw new SellerNotPresent();
        }
        Seller seller=s.get();
        Product product= ProductTransformer.ProductRequesttoProduct(request);
        product.setSeller(seller);
        product.setStatus(ProductStatus.AVAILABLE);
        seller.getProductList().add(product);
        Seller savedSeller=sellerRepo.save(seller);

        Product savedProduct=savedSeller.getProductList().get(savedSeller.getProductList().size()-1);

        return ProductTransformer.ProductToproductResponse(savedProduct);
    }
}
