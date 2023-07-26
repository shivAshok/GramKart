package com.example.GramKart.Model;

import com.example.GramKart.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name="Seller_Table")
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class Seller {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    String name;

    @Column(unique = true)
    String emailId;
    @Column(unique = true)
    String mobileNo;

    @Column(unique = true)
    String panNo;
    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    List<Product> productList=new ArrayList<>();

}
