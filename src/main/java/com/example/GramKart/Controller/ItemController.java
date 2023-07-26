package com.example.GramKart.Controller;

import com.example.GramKart.Dto.Request.ItemRequest;
import com.example.GramKart.Dto.Response.ItemResponse;
import com.example.GramKart.Exception.CustomerNotPresent;
import com.example.GramKart.Exception.ProductNotPresent;
import com.example.GramKart.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Item")
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping("/add-item-to_cart")
    public ResponseEntity addItemTocart(@RequestBody ItemRequest itemRequest) {
        try {
            ItemResponse itemResponse = itemService.addItemTocart(itemRequest);
            return new ResponseEntity<>(itemResponse, HttpStatus.OK);
        } catch (CustomerNotPresent ex) {
            return new ResponseEntity("invalid customer id", HttpStatus.BAD_REQUEST);
        } catch (ProductNotPresent ex) {
            return new ResponseEntity("invalid product id", HttpStatus.BAD_REQUEST);
        }
    }


}
