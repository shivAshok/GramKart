package com.example.GramKart.Transformer;

import com.example.GramKart.Dto.Request.SellerRequest;
import com.example.GramKart.Dto.Response.SellerResponse;
import com.example.GramKart.Model.Seller;

public class SellerTransformer {
    public static Seller  sellerRequestToSeller(SellerRequest request){
        Seller seller=Seller.builder().age(request.getAge()).emailId(request.getEmailId())
                .panNo(request.getPanNo()).name(request.getName()).gender(request.getGender()).
                mobileNo(request.getMobileNo())
                .build();
        return seller;
    }
    public static SellerResponse SellerToSellerResponse(Seller seller){
        SellerResponse response=SellerResponse.builder().name(seller.getName()).age(seller.getAge())
                .emailId(seller.getEmailId()).gender(seller.getGender()).mobileNo(seller.getMobileNo()).id(seller.getId()).build();
        return response;
    }
}
