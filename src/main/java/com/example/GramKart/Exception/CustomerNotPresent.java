package com.example.GramKart.Exception;

public class CustomerNotPresent extends RuntimeException{
   public CustomerNotPresent(String msg){
        super(msg);
    }
}
