package com.example.GramKart.Exception;

public class ProductOutOfStock extends RuntimeException{
    public ProductOutOfStock(){
        super("Product Out_OfStock");
    }
}
