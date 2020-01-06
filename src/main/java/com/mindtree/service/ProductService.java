package com.mindtree.service;

import com.mindtree.dto.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
        Iterable<Product> getAllProducts();
        Product getProduct(int id);
        Product save(Product product);
        List<Product> getProductByCategory(String category);
        List<Product> getProductByName(String name);
}
