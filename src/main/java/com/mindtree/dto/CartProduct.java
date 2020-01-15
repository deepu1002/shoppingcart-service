package com.mindtree.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private Integer productId;
    private String name;
    private Float price;
    private Integer quantity;

    @Column(nullable = false)
    private String userName;
}