package com.example.GramKart.Controller;

import com.example.GramKart.Dto.Request.ProductRequest;
import com.example.GramKart.Dto.Response.ProductResponse;
import com.example.GramKart.Exception.SellerNotPresent;
import com.example.GramKart.Service.ProductServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    ProductServive productServive;
    @PostMapping("/add-product")
    public ResponseEntity addProduct(@RequestBody ProductRequest request){
        try {
            ProductResponse response = productServive.addProduct(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(SellerNotPresent ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
        }
    }
}
