package com.product.reviewsite.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.reviewsite.entities.Product;
import com.product.reviewsite.entities.Reviews;
import com.product.reviewsite.model.Model;
import com.product.reviewsite.services.ProductServices;
import com.product.reviewsite.services.RegistrationServices;
import com.product.reviewsite.services.ReviewServices;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewsController {

	@Autowired
	private ReviewServices reviewService;
	@Autowired
	private ProductServices productService;
	@Autowired
	private RegistrationServices registrationService;

	/*
	 * This API is used to get allReview with respect productId
	 * 
	 * @Param productId
	 * 
	 * @Return List<Reviews>
	 */
	@GetMapping("/getAllReview/{id}")
	public List<Reviews> getAllReview(@PathVariable(value = "id") String id) throws Exception {
		List<Reviews> results;
		try {
			Product productObj = productService.getProduct(id);
			results = reviewService.getAllReview(productObj);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return results;
	}

	/*
	 * This API is used to store the reviews with respect prodductId
	 * 
	 * @Param peoductId
	 * 
	 * @Return nothing
	 */
	@PutMapping("/insertReview/{id}")
	public void insertReview(@RequestBody Reviews review, @PathVariable(value = "id") String id) throws Exception {
		Product product;
		List<Reviews> review1;
		try {
			product = productService.getProduct(id);
			review1 = product.getReviews();
			review1.add(review);
			review.setProduct(product);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			review.setDate(dateFormat.format(date));
			productService.updateProductReview(product);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * This API is used to get stats details
	 * 
	 * @Param nothing
	 * 
	 * @Return Model
	 */
	@GetMapping("/getstats")
	public Model getStats() throws Exception {
		Model model = new Model();
		try {
			model.countUsers = registrationService.countAllRegistrated();
			model.countReviews = reviewService.countAllReview();
			model.countPosts = productService.countAllProduct();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return model;
	}

	/*
	 * This API is used to get the average of all rating
	 * 
	 * @Param productId
	 * 
	 * @Return Integer
	 */
	@GetMapping("/getAvgRating/{id}")
	public Integer getAvgRating(@PathVariable("id") String productCode) throws Exception {
		if (productCode == null) {
			throw new Exception("Id is null!Please try again");
		}
		Product product = null;
		try {
			product = this.productService.getProduct(productCode);
		} catch (Exception e) {
			throw new Exception("Product not found");
		}
		Double average = this.reviewService.getAverage(product);
		if (average == null) {
			return 0;
		}
		double avg = average;
		return (int) avg;
	}
}
