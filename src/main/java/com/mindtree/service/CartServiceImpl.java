package com.mindtree.service;

import com.mindtree.dto.CartProduct;
import com.mindtree.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE , propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Iterable<CartProduct> findByUserName(String userName) {
        Iterable<CartProduct> cartProducts = this.cartRepository.findByUserName(userName);
        log.debug("Cart Products for user : " + userName +", "+cartProducts);
        return cartProducts;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE , propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Iterable<CartProduct> getAllCartItems() {
        Iterable<CartProduct> cartProducts = this.cartRepository.findAll();
        log.debug("All Cart Products : "+ cartProducts );
        return cartProducts;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public CartProduct addCartProduct(CartProduct cartProduct) {
        log.debug("Saving Cart Product : "+ cartProduct );
        return this.cartRepository.save(validateProductsExistence(cartProduct));
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public CartProduct updateCartProduct(CartProduct cartProduct) {
        if(cartProduct.getQuantity() > 0) {
            return this.cartRepository.save(cartProduct);
        } else {
            log.debug("Deleting Cart Product for ID : "+ cartProduct.getId() );
            deleteCartProduct(cartProduct.getId());
            return null;
        }
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void deleteCartProduct(int cartProductId) {
        log.debug("Deleting Cart Product for ID : "+ cartProductId );
        this.cartRepository.deleteById(cartProductId);
    }

    private CartProduct validateProductsExistence(CartProduct cartProduct) {
        log.debug("Validate product existence : "+ cartProduct );
        CartProduct dbProduct = cartRepository.findByProductIdAndUserName(cartProduct.getProductId(), cartProduct.getUserName());
        log.debug("Product returned from db : "+ dbProduct );
        if(Objects.nonNull(dbProduct)) {
            cartProduct.setId(dbProduct.getId());
            cartProduct.setQuantity(dbProduct.getQuantity()+1);
        }
        return cartProduct;
    }
}