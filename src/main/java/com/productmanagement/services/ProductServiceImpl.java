package com.productmanagement.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import com.productmanagement.models.Category;
import com.productmanagement.models.Product;
import com.productmanagement.repositories.CategoryRepository;
import com.productmanagement.repositories.ProductRepository;
import com.productmanagement.requests.CreateOrUpdateProductRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
	

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	private CategoryService categoryService;
	
	@Override
	public Product create(CreateOrUpdateProductRequest product) {
		
		Product entity = new Product();
		BeanUtils.copyProperties(product, entity);
		
		Category category = this.categoryRepository.findById(UUID.fromString(product.getCategoryId())).orElse(null);
		System.out.println(category);
		
		entity.setCategory(category);
		
		entity.setCreationDate(new Date());
		entity.setLastUpdateDate(new Date());
		
		
		return this.productRepository.save(entity);
	}

	@Override
	public Product getProductById(String productId) {
		
		Product product = this.productRepository.findById(UUID.fromString(productId))
												.orElseThrow(() -> new DataAccessResourceFailureException("Registro não encontrado!"));
		
		return product;
	}

	
	@Override
	public List<Product> getProductsByCategoryId(UUID categoryId) {
		// TODO Auto-generated method stub
		//return this.categoryService.getProductsByCategory(categoryId);
		
		return this.productRepository.findByCategoryId(categoryId);
	}

	@Override
	public Product update(String productId, CreateOrUpdateProductRequest createOrUpdateProductRequest) {
		// TODO Auto-generated method stub
		
		Product product = this.getProductById(productId);
		
		if(createOrUpdateProductRequest.getName() != null)
			product.setName(createOrUpdateProductRequest.getName());
		
		if(createOrUpdateProductRequest.getColor() != null)
			product.setColor(createOrUpdateProductRequest.getColor());
		
		if(createOrUpdateProductRequest.getDescription() != null)
			product.setDescription(createOrUpdateProductRequest.getDescription());
		
		if(createOrUpdateProductRequest.getCategoryId() != null)
			product.setCategory(this.categoryRepository.getById(UUID.fromString(createOrUpdateProductRequest.getCategoryId())));
		
		
		product.setLastUpdateDate(new Date());
		
		this.productRepository.save(product);
		
		return product;
	}
		
}
