package com.mindtree.service;

import com.mindtree.dto.Cart;
import com.mindtree.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Iterable<Cart> getAllCartItems() {
        return this.cartRepository.findAll();
    }

    @Override
    public Cart create(Cart cart) {
        return this.cartRepository.save(cart);
    }

    @Override
    public void update(Cart cart) {
        this.cartRepository.save(cart);
    }
}