package com.example.GramKart.Service;

import com.example.GramKart.Dto.Request.CustomerRequest;
import com.example.GramKart.Dto.Response.CustomerResponse;
import com.example.GramKart.Model.Cart;
import com.example.GramKart.Model.Customer;
import com.example.GramKart.Repository.CustomerRepo;
import com.example.GramKart.Transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer= CustomerTransformer.CustomerRequestToCustomer(customerRequest);

        Cart cart=new Cart();

        cart.setCustomer(customer);
        customer.setCustomerCart(cart);

        Customer savedCustomer=customerRepo.save(customer);
        return CustomerTransformer.CustomertoCutomerResponse(savedCustomer);
    }
}
