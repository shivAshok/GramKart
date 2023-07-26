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
@Table(name="Customer")
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(unique = true)
    String emailId;

    @Column(unique = true,name = "mobileNo")
    String phoneNo;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<OrderIntity>  customerOrder=new ArrayList<>();

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    Cart customerCart;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Card> cardList=new ArrayList<>();


}
