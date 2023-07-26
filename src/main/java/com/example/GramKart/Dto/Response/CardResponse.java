package com.example.GramKart.Dto.Response;

import com.example.GramKart.Enums.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CardResponse {

    String cardNo;

    int cvvNo;

    Date validTill;

    CardType cardType;

    String cutomerName;
}
