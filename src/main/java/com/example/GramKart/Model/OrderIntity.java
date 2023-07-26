package com.example.GramKart.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name="Order_Table")
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class OrderIntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    String orderId;//uuid

    @CreationTimestamp
    Date date;

    String cardUsed;

    int orderTotal;

    @OneToMany(mappedBy = "orderIntity",cascade = CascadeType.ALL)
    List<Item>  itemList=new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Customer customer;

}
