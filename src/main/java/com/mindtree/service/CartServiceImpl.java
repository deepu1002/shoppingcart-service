package com.mindtree.service;

import com.mindtree.dto.CartProduct;
import com.mindtree.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Iterable<CartProduct> findByUserName(String userName) {
        return this.cartRepository.findByUserName(userName);
    }

    @Override
    public Iterable<CartProduct> getAllCartItems() {
        return this.cartRepository.findAll();
    }

    @Override
    public CartProduct addCartProduct(CartProduct cartProduct) {
        return this.cartRepository.save(validateProductsExistence(cartProduct));
    }

    @Override
    public CartProduct updateCartProduct(CartProduct cartProduct) {
        if(cartProduct.getQuantity() > 0) {
            return this.cartRepository.save(cartProduct);
        } else {
            deleteCartProduct(cartProduct.getId());
            return null;
        }
    }

    @Override
    public void deleteCartProduct(int cartProductId) {
        this.cartRepository.deleteById(cartProductId);
    }

    private CartProduct validateProductsExistence(CartProduct cartProduct) {
        CartProduct dbProduct = cartRepository.findByProductIdAndUserName(cartProduct.getProductId(), cartProduct.getUserName());
        if(Objects.nonNull(dbProduct)) {
            cartProduct.setId(dbProduct.getId());
            cartProduct.setQuantity(dbProduct.getQuantity()+1);
        }
        return cartProduct;
    }
}