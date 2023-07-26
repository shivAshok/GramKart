package com.example.GramKart.Service;

import com.example.GramKart.Dto.Request.SellerRequest;
import com.example.GramKart.Dto.Response.SellerResponse;
import com.example.GramKart.Model.Seller;
import com.example.GramKart.Repository.SellerRepo;
import com.example.GramKart.Transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellarService {
    @Autowired
    SellerRepo sellerRepo;
    public SellerResponse addSeller(SellerRequest request) {
        Seller seller= SellerTransformer.sellerRequestToSeller(request);
        Seller savedseler=sellerRepo.save(seller);
        return SellerTransformer.SellerToSellerResponse(savedseler);
    }
}
