package com.mindtree.service;

import com.mindtree.dto.CartProduct;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    Iterable<CartProduct> getAllCartItems();
    Iterable<CartProduct> findByUserName(String userName);
    CartProduct addCartProduct(CartProduct cartProduct);
    CartProduct updateCartProduct(CartProduct cartProduct);
    void deleteCartProduct(int cartProductId);
}
