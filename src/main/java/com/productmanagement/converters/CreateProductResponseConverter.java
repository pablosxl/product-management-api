package com.productmanagement.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.productmanagement.models.Product;
import com.productmanagement.responses.CreateProductResponse;

@Component
public class CreateProductResponseConverter  implements Converter<Product, CreateProductResponse> {

	@Override
	public CreateProductResponse convert(Product source) {
		// TODO Auto-generated method stub
		return new CreateProductResponse(
				source.getId(), 
				source.getCategory().getId(), 
				source.getName(), 
				source.getDescription(), 
				source.getColor(), 
				source.getCreationDate());
	}

}
