package com.productmanagement.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.productmanagement.converters.CreateProductResponseConverter;
import com.productmanagement.models.Product;
import com.productmanagement.requests.CreateOrUpdateProductRequest;
import com.productmanagement.responses.CreateProductResponse;
import com.productmanagement.services.ProductService;
import com.productmanagement.services.ProductServiceImpl;

import jdk.jfr.BooleanFlag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	private final CreateProductResponseConverter createProductResponseConverter;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/product")
	public CreateProductResponse create(@RequestBody CreateOrUpdateProductRequest createOrUpdateProductRequest) {
		
		Product response = this.productService.create(createOrUpdateProductRequest);
		
		return this.createProductResponseConverter.convert(response);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/product/{id}")
	public Product update(@PathVariable String id, @RequestBody CreateOrUpdateProductRequest createOrUpdateProductRequest) {
		
		return this.productService.update(id, createOrUpdateProductRequest);
	}
	
	@GetMapping("/product/{id}")
	public Product getById(@PathVariable String id) {
		
		
		return this.productService.getProductById(id);
	}
	
	@GetMapping("/product/category/{id}")
	public List<Product> getProductsByCategoryId(@PathVariable UUID id) {
		
		return this.productService.getProductsByCategoryId(id);
	}
	

}
