package com.product.reviewsite.services;

import java.util.List;

import com.product.reviewsite.entities.Product;



public interface SearchProductServiceInterface {

	public List<Product> getProductListBySearch(String search);

	public List<Product> searchPrice(int min, int max, String brand);
	
	

}
