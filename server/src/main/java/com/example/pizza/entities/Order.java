package com.example.pizza.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;

    private String name;

    private String orderedDateTime;

    private String deliveryAddress;

    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "fk_id", referencedColumnName = "order_id")
    private List<Pizza> pizzas;

    @OneToMany
    @JoinColumn(name = "fk_id", referencedColumnName = "order_id")
    private List<Drink> drinks;
}
