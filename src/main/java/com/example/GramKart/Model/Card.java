package com.example.GramKart.Model;

import com.example.GramKart.Enums.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Card")
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    String cardNo;

    int cvvNo;

    Date validTill;

    @Enumerated(EnumType.STRING)
    CardType cardType;

    @ManyToOne
    @JoinColumn
    Customer customer;
}
