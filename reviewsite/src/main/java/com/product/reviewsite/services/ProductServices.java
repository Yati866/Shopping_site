package com.product.reviewsite.services;

import java.util.List;

import com.product.reviewsite.entities.Product;

public interface ProductServices {
	 public List<Product> getAllProducts();
     public Product getProduct(String productCode);	 
	 public Product saveProduct(Product product);
	 public void updateProductReview(Product product);
	 public Long countAllProduct();
}
