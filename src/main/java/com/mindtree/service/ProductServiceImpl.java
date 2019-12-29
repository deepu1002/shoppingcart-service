package com.mindtree.service;

import com.mindtree.dto.Product;
import com.mindtree.exception.ResourceNotFoundException;
import com.mindtree.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(int id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return productRepository.findByCategory(category);

    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }


}