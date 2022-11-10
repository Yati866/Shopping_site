package com.product.reviewsite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.reviewsite.entities.Product;
import com.product.reviewsite.repository.ProductRepository;



@Service
public class ProductServicesImpl implements ProductServices {
	@Autowired
	private ProductRepository repo;

	/**
	 * This method is used to save product
	 */
	@Override
	public Product saveProduct(Product product) {
		Product productObj = repo.save(product);
		return productObj;
	}
	/**
	 * This method is used to get all products in the database
	 */
	public List<Product> getAllProducts() {
		List<Product> productObj = repo.findAll();
		return productObj;
	}

	/**
	 * This method is used to get product with help of productCode
	 */
	@Override
	public Product getProduct(String productCode) {

		Product productObj = repo.findByProductCode(productCode);
		return productObj;
	}

	/**
	 * This method is used to save review
	 */
	@Override
	public void updateProductReview(Product product) {
		repo.save(product);
	}

	/**
	 * This method is used to count product
	 */
	@Override
	public Long countAllProduct() {
		return repo.count();
	}

	
}

