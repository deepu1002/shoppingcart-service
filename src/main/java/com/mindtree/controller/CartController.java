package com.mindtree.controller;

import com.mindtree.dto.CartProduct;
import com.mindtree.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<CartProduct> list() {
        return this.cartService.getAllCartItems();
    }

    @GetMapping("/name/{userName}")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<CartProduct> cartProductsByUser(@PathVariable("userName") String userName) {
        return this.cartService.findByUserName(userName);
    }

    @PostMapping
    public CartProduct addCartProduct(@RequestBody CartProduct cartProduct) {
        return cartService.addCartProduct(cartProduct);
    }

    @PutMapping
    public CartProduct updateCartProduct(@RequestBody CartProduct cartProduct) {
        return cartService.updateCartProduct(cartProduct);
    }

    @DeleteMapping(value = { "/{id}"})
    public void deleteCartProduct(@PathVariable("id") int cartProductId) {
        cartService.deleteCartProduct(cartProductId);
    }
}

