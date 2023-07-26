package com.example.GramKart.Dto.Request;

import com.example.GramKart.Enums.CardType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CardRequest {
    String cardNo;

    int cvvNo;

    Date validTill;

    CardType cardType;

    String customerEmailId;
}
