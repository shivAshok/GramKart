package com.example.GramKart.Controller;

import com.example.GramKart.Dto.Request.CustomerRequest;
import com.example.GramKart.Dto.Response.CustomerResponse;
import com.example.GramKart.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cutomer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add-customer")
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse response=customerService.addCustomer(customerRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
