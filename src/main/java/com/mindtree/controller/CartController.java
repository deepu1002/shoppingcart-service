package com.mindtree.controller;

import com.mindtree.dto.CartProduct;
import com.mindtree.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<CartProduct> cartItems() {
        log.info("Request to get all cartItems");
        return this.cartService.getAllCartItems();
    }

    @GetMapping("/name/{userName}")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<CartProduct> cartProductsByUser(@PathVariable("userName") String userName) {
        log.info("Request to get all cart products by user");
        return this.cartService.findByUserName(userName);
    }

    @PostMapping
    public CartProduct addCartProduct(@RequestBody CartProduct cartProduct) {
        log.info("Request to add cart product : " +cartProduct);
        return cartService.addCartProduct(cartProduct);
    }

    @PutMapping
    public CartProduct updateCartProduct(@RequestBody CartProduct cartProduct) {
        log.info("Request to update cart product : " +cartProduct);
        return cartService.updateCartProduct(cartProduct);
    }

    @DeleteMapping(value = { "/{id}"})
    public void deleteCartProduct(@PathVariable("id") int cartProductId) {
        log.info("Request to delete cart product by ID : " +cartProductId);
        cartService.deleteCartProduct(cartProductId);
    }
}

