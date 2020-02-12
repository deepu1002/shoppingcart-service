package com.mindtree.service;

import com.mindtree.dto.Product;
import com.mindtree.exception.ResourceNotFoundException;
import com.mindtree.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE , propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Iterable<Product> getAllProducts() {
        Iterable<Product> products = productRepository.findAll();
        log.debug("All products : "+ products);
        return products;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE , propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Product getProduct(int id) {
        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        log.debug("Get Product by id  : "+ id + ", " + product);
        return product;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE , propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<Product> getProductByCategory(String category) {
        List<Product> products = productRepository.findByCategory(category);
        log.debug("Get Product by category  : "+ category + ", " + products);
        return products;

    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Product save(Product product) {
        log.debug("Saving Product : "+ product);
        return productRepository.save(product);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE , propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<Product> getProductByName(String name) {
        List<Product> products = productRepository.findByName(name);
        log.debug("Get Product by name  : "+ name + ", " + products);
        return products;
    }
}