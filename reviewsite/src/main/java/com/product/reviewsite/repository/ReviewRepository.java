package com.product.reviewsite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.product.reviewsite.entities.Product;
import com.product.reviewsite.entities.Reviews;


public interface ReviewRepository extends JpaRepository<Reviews, Integer> {
	public List<Reviews> findByProduct(Product product);

	@Query("select avg(r.rating) from Reviews r where r.product=:product")
	public Double getAverage(@Param("product") Product product);
}
