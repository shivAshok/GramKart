package com.example.GramKart.Exception;

public class ProductNotPresent extends RuntimeException{
    public ProductNotPresent(String msg){
        super(msg);
    }
}
