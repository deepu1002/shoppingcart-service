package com.mindtree.repository;

import com.mindtree.dto.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartProduct, Integer> {

    CartProduct findByProductIdAndUserName(Integer productId, String userName);
    List<CartProduct> findByUserName(String name);

}
