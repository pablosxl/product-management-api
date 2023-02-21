package com.productmanagement.responses;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateProductResponse {
	
	private UUID id;
	private UUID categoryId;
	private String name;
	private String description;
	private String color;
	private Date creationDate;
}
