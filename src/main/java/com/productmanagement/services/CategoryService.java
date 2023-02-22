package com.productmanagement.services;

import java.util.List;
import java.util.UUID;

import com.productmanagement.models.Product;

public interface CategoryService {
	
	public List<Product> getProductsByCategory(UUID categoryId);
}
