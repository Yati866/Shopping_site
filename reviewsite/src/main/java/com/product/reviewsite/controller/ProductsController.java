package com.product.reviewsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.product.reviewsite.entities.Product;
import com.product.reviewsite.services.ProductServices;



@RestController
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@CrossOrigin(origins = "http://localhost:4200")
public class ProductsController {
	@Autowired
	private ProductServices service;

	/*
	 * This API is used to get the product with help of productId
	 * 
	 * @Param productId
	 * 
	 * @Return Product
	 */
	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable("id") String productCode) throws Exception {
		try {
			return this.service.getProduct(productCode);
		} catch (Exception e) {
			throw new Exception("FETCHING_FAILED");
		}
	}
	@GetMapping("/getAllProducts")
	public List<Product> fetchAllProducts(){
		return this.service.getAllProducts();
	}
}
