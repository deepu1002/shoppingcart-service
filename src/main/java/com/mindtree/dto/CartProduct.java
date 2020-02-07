package com.mindtree.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Integer productId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Float price;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name ="USERNAME", nullable = false)
    private String userName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartProduct)) return false;
        CartProduct that = (CartProduct) o;
        return getId().equals(that.getId()) &&
                getProductId().equals(that.getProductId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getQuantity(), that.getQuantity()) &&
                Objects.equals(getUserName(), that.getUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductId(), getName(), getPrice(), getQuantity(), getUserName());
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "id=" + id +
                ", productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", userName='" + userName + '\'' +
                '}';
    }
}