package com.example.GramKart.Dto.Request;

import com.example.GramKart.Enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SellerRequest {
    String name;


    String emailId;

    String mobileNo;


    String panNo;
    int age;

    Gender gender;
}
