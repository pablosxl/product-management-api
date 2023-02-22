package com.productmanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.productmanagement.models.Product;
import com.productmanagement.repositories.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	
	
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Product> getProductsByCategory(UUID categoryId) {
		// TODO Auto-generated method stub
		
		Optional<Object> products = this.categoryRepository.findById(categoryId).map(value -> value.getProducts());
		
		
		return this.categoryRepository.findById(categoryId)
									  .map(value -> value.getProducts()
										       			 .stream()
										       			 .collect(Collectors.toCollection(ArrayList::new)))
									  .orElse(null);
	}
	
	
}
