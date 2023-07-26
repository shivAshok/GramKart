package com.example.GramKart.Dto.Response;

import com.example.GramKart.Enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerResponse {
    String name;

   int id;
    String emailId;

    String mobileNo;


    int age;

    Gender gender;
}
