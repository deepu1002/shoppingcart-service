package com.mindtree.controller;

import com.mindtree.dto.Product;
import com.mindtree.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
 
    @GetMapping(value = { "products/", "/" })
    public Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = { "products/id/{id}"})
    public Product getProductById(@PathVariable("id") int id) {
        return productService.getProduct(id);
    }

    @GetMapping(value = { "products/category/{category}"})
    public List<Product> getProductByCategory(@PathVariable("category") String category) {
        return productService.getProductByCategory(category);
    }
}