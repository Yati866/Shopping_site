package com.product.reviewsite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.reviewsite.entities.Product;
import com.product.reviewsite.entities.Reviews;
import com.product.reviewsite.repository.ReviewRepository;



@Service
public class ReviewServiceImpl implements ReviewServices {

	@Autowired
	private ReviewRepository repo;

	/**
	 * This method is used to get list of review
	 */
	@Override
	public List<Reviews> getAllReview(Product product) {
		return repo.findByProduct(product);
	}

	/**
	 * This method is used to get all count review
	 */

	@Override
	public Long countAllReview() {
		return repo.count();
	}

	/**
	 * This method is used to get average of review rating
	 */
	@Override
	public Double getAverage(Product product) {
		return repo.getAverage(product);
	}
}

