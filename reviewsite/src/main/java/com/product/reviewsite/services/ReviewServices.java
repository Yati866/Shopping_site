package com.product.reviewsite.services;

import java.util.List;

import com.product.reviewsite.entities.Product;

import com.product.reviewsite.entities.Reviews;

public interface ReviewServices {
	
	
	
	
	public List<Reviews> getAllReview(Product product);

	public Long countAllReview();

	public Double getAverage(Product product);
	

}
