package com.example.GramKart.Service;

import com.example.GramKart.Dto.Request.CardRequest;
import com.example.GramKart.Dto.Response.CardResponse;
import com.example.GramKart.Exception.CustomerNotPresent;
import com.example.GramKart.Model.Card;
import com.example.GramKart.Model.Customer;
import com.example.GramKart.Repository.CardRepo;
import com.example.GramKart.Repository.CustomerRepo;
import com.example.GramKart.Transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardRepo cardRepo;

    @Autowired
    CustomerRepo customerRepo;
    public CardResponse addCard(CardRequest cardRequest) {
        Optional<Customer> ct=customerRepo.findByEmailId(cardRequest.getCustomerEmailId());
        if(ct.isEmpty()){
            throw new CustomerNotPresent("customer is not present");
        }
        Customer customer=ct.get();
        Card card= CardTransformer.cardRequestToCard(cardRequest);
        card.setCustomer(customer);

        customer.getCardList().add(card);
        Customer savedCt=customerRepo.save(customer);
        Card savedCard=savedCt.getCardList().get(savedCt.getCardList().size()-1);
        CardResponse response=CardTransformer.cardTocardResponse(savedCard);
        String tem="X";
        String cardNo=tem.repeat(savedCard.getCardNo().length()-4);
        cardNo+=savedCard.getCardNo().substring(savedCard.getCardNo().length()-4,savedCard.getCardNo().length());
         response.setCardNo(cardNo);
         return response;
    }
}
