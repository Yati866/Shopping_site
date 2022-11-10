package com.product.reviewsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.reviewsite.entities.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	public Product findByProductCode(String ProductCode);

}
