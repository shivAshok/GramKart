package com.example.GramKart.Transformer;

import com.example.GramKart.Dto.Request.CardRequest;
import com.example.GramKart.Dto.Response.CardResponse;
import com.example.GramKart.Model.Card;
import com.example.GramKart.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class CardTransformer {


    public static Card cardRequestToCard(CardRequest request){
        Card card=Card.builder().cardNo(request.getCardNo()).cvvNo(request.getCvvNo()).
                cardType(request.getCardType()).validTill(request.getValidTill()).
                build();
        return card;
    }
    public static CardResponse cardTocardResponse(Card card){
        CardResponse response=CardResponse.builder().
                 cardType(card.getCardType()).
                cvvNo(card.getCvvNo()).validTill(card.getValidTill()).
                cutomerName(card.getCustomer().getName()).
                build();
        return response;
    }
}
