package com.example.GramKart.Controller;

import com.example.GramKart.Dto.Request.OrderRequestDto;
import com.example.GramKart.Dto.Response.OrderResponse;
import com.example.GramKart.Exception.CustomerNotPresent;
import com.example.GramKart.Exception.ProductNotPresent;
import com.example.GramKart.Exception.ProductOutOfStock;
import com.example.GramKart.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/place-Order-directly")
    public ResponseEntity PlaceOrderDirect(@RequestBody OrderRequestDto requestDto){
       try{
           OrderResponse response=orderService.placeOrderWithoutCart(requestDto);
           return new ResponseEntity<>(response, HttpStatus.OK);
       }
       catch(ProductNotPresent ex){
           return new ResponseEntity("product not present",HttpStatus.BAD_REQUEST);
       }
       catch(CustomerNotPresent ex){
           return new ResponseEntity("customer not present",HttpStatus.BAD_REQUEST);
       }
       catch(ProductOutOfStock ex){
           return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }

}
