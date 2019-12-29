package com.mindtree.model;

import com.mindtree.dto.CartProduct;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class CartRequest {
    private List<CartProduct> cartProducts;
}
