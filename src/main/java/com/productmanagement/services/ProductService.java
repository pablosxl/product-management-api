package com.productmanagement.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.productmanagement.models.Product;
import com.productmanagement.requests.*;

public interface ProductService {
	
	public Product create(CreateOrUpdateProductRequest product);
	
	public Product update(String productId, CreateOrUpdateProductRequest createOrUpdateProductRequest);
	
	public Product getProductById(String productId);
	
	public List<Product> getProductsByCategoryId(UUID categoryId);
}
