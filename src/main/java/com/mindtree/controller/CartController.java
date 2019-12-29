package com.mindtree.controller;

import com.mindtree.dto.Cart;
import com.mindtree.dto.CartProduct;
import com.mindtree.exception.ResourceNotFoundException;
import com.mindtree.model.CartRequest;
import com.mindtree.service.CartProductService;
import com.mindtree.service.CartService;
import com.mindtree.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartProductService cartProductService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Cart> list() {
        return this.cartService.getAllCartItems();
    }

    @PostMapping
    public ResponseEntity<Cart> create(@RequestBody CartRequest form) {
        List<CartProduct> formDtos = form.getCartProducts();
        validateProductsExistence(formDtos);
        Cart cart = new Cart();
        cart = this.cartService.create(cart);

        List<CartProduct> cartProducts = new ArrayList<>();
        for (CartProduct dto : formDtos) {
            cartProducts.add(cartProductService.create(new CartProduct(cart, productService.getProduct(dto
                    .getProduct().getId()), dto.getQuantity())));
        }

        cart.setCartProducts(cartProducts);

        this.cartService.update(cart);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/cart/{id}")
                .buildAndExpand(cart.getCartId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(cart, headers, HttpStatus.CREATED);
    }

    private void validateProductsExistence(List<CartProduct> cartProducts) {
        List<CartProduct> list = cartProducts
                .stream()
                .filter(op -> Objects.isNull(productService.getProduct(op
                        .getProduct()
                        .getId())))
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
            new ResourceNotFoundException("Product not found");
        }
    }
}

