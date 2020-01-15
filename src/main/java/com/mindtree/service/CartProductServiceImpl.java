//package com.mindtree.service;
//
//import com.mindtree.dto.CartProduct;
//import com.mindtree.repository.CartProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@Service
//@Transactional
//public class CartProductServiceImpl implements CartProductService {
//
//    @Autowired
//    private CartProductRepository cartProductRepository;
//
//    @Override
//    public CartProduct create(CartProduct cartProduct) {
//        return this.cartProductRepository.save(cartProduct);
//    }
//}