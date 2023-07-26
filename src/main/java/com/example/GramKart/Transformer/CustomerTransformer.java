package com.example.GramKart.Transformer;

import com.example.GramKart.Dto.Request.CustomerRequest;
import com.example.GramKart.Dto.Response.CustomerResponse;
import com.example.GramKart.Model.Customer;

public class CustomerTransformer {

    public static Customer CustomerRequestToCustomer(CustomerRequest request){
        Customer customer=Customer.builder().name(request.getName()).
                           gender(request.getGender()).
                           emailId(request.getEmailId()).
                           age(request.getAge()).
                           phoneNo(request.getMoblileNo()).build();
        return customer;
    }

    public static CustomerResponse CustomertoCutomerResponse(Customer customer){

        CustomerResponse response=CustomerResponse.builder().name(customer.getName()).
                                   age(customer.getAge()).gender(customer.getGender()).emailId(customer.getEmailId()).
                                   moblileNo(customer.getPhoneNo()).build();
        return response;
    }


}
