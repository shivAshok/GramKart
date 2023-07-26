package com.example.GramKart.Controller;

import com.example.GramKart.Dto.Request.CardRequest;
import com.example.GramKart.Dto.Response.CardResponse;
import com.example.GramKart.Exception.CustomerNotPresent;
import com.example.GramKart.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping("/add-Card")
    public ResponseEntity addCard(@RequestBody CardRequest cardRequest){
        try {
            CardResponse response = cardService.addCard(cardRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(CustomerNotPresent ex){
            return new ResponseEntity("invalid customer Id",HttpStatus.BAD_REQUEST);
        }
    }
}
