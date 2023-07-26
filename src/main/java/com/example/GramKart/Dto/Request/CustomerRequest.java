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
public class CustomerRequest {
    String name;


    String emailId;


    String moblileNo;
    int age;


    Gender gender;
}
