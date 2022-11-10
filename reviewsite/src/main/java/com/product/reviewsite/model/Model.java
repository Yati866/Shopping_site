package com.product.reviewsite.model;

public class Model {
	
	public long countUsers;
	public long countReviews;
	public long countPosts;

	public Model() {
		super();

	}

	public Model(long countUsers, long countReviews, long countPosts) {
		super();
		this.countUsers = countUsers;
		this.countReviews = countReviews;
		this.countPosts = countPosts;
	}

}
