package com.example.GramKart.Controller;

import com.example.GramKart.Dto.Request.SellerRequest;
import com.example.GramKart.Dto.Response.SellerResponse;
import com.example.GramKart.Service.SellarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellarService sellarService;

    @PostMapping("/add-seller")
    public SellerResponse addSeller(@RequestBody SellerRequest request){
        SellerResponse response=sellarService.addSeller(request);
        return response;
    }
}
