package com.product.reviewsite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.reviewsite.entities.Product;
import com.product.reviewsite.repository.SearchProductRepository;



@Service
public class SearchProductService implements SearchProductServiceInterface {

	@Autowired
	private SearchProductRepository repo;
	
	/**
	 * This method is used to get list of product based on search
	 */
	@Override
	public List<Product> getProductListBySearch(String search) {
		return repo.findBySearch(search);
	}
	
	/**
	 * This method is used to get list of product based on price range given by user
	 */
	@Override
	public List<Product> searchPrice(int min, int max, String brand) {
		// TODO Auto-generated method stub
		return repo.searchPrice(min, max,brand);
	}

}
