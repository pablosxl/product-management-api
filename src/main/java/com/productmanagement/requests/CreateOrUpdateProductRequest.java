package com.productmanagement.requests;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateOrUpdateProductRequest {
	
	private String name;
	private String description;
	private String color;
	private String categoryId;
	
}
