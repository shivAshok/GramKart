package com.example.GramKart.Exception;

public class ProductNotAvailable extends RuntimeException{
   public ProductNotAvailable(String msg){
        super(msg);
    }
}
