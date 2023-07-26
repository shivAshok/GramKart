package com.example.GramKart.Exception;

public class SellerNotPresent extends RuntimeException{
   public SellerNotPresent(){
        super("invalid seller id");
    }
}
