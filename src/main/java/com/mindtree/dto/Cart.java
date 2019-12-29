package com.mindtree.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    @JsonManagedReference
    @OneToMany(mappedBy = "pk.cart")
    @Valid
    private List<CartProduct> cartProducts = new ArrayList<>();

    @Transient
    public Float getTotalCartPrice() {
        float sum = 0f;
        List<CartProduct> cartProducts = getCartProducts();
        for (CartProduct cartProduct : cartProducts) {
            sum += cartProduct.getTotalPrice();
        }
        return sum;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.cartProducts.size();
    }
}

