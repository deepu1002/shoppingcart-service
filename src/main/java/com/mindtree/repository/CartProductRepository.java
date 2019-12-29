package com.mindtree.repository;

import com.mindtree.dto.CartProduct;
import com.mindtree.dto.CartProductPK;
import org.springframework.data.repository.CrudRepository;

public interface CartProductRepository extends CrudRepository<CartProduct, CartProductPK> {
}