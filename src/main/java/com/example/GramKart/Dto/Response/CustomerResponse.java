package com.example.GramKart.Dto.Response;

import com.example.GramKart.Enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    String name;


    String emailId;

      int age;
    String moblileNo;

    Gender gender;

}
