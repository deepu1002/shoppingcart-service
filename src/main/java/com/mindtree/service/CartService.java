package com.mindtree.service;

import com.mindtree.dto.Cart;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    Iterable<Cart> getAllCartItems();
    Cart create(Cart cart);
    void update(Cart cart);
}
