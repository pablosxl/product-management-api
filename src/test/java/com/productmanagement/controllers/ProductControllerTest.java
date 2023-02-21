package com.productmanagement.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.productmanagement.models.Category;
import com.productmanagement.models.Product;
import com.productmanagement.requests.CreateOrUpdateProductRequest;
import com.productmanagement.services.ProductService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	
	
	private static final UUID ID = UUID.randomUUID();
	private static final String CATEGORY_ID = UUID.randomUUID().toString();
	private static final String NAME="Camisa regata";
	private static final String DESCRIPTION = "camisa gola v";
	private static final String COLOR = "verde";
	private static final Date CREATIONDATE=new Date();
	private static final Date LASTUPDATEDATE=new Date();
	private static final Category CATEGORY=new Category();
	
	private static final CreateOrUpdateProductRequest CREATE_PRODUCT_REQUEST = new CreateOrUpdateProductRequest(NAME, DESCRIPTION, COLOR, CATEGORY_ID);
	private static final Product CREATE_PRODUCT_RESPONSE = new Product(ID , NAME, DESCRIPTION, COLOR, CREATIONDATE, LASTUPDATEDATE, CATEGORY);
	
	@Autowired
    private MockMvc mockMvc;
		
	@MockBean
	private ProductService productService;
	
	
	@Test
	public void testCreateProduct() throws Exception {
		
		when(productService.create(Mockito.any(CreateOrUpdateProductRequest.class))).thenReturn(new Product(ID , NAME, DESCRIPTION, COLOR, CREATIONDATE, LASTUPDATEDATE, CATEGORY));
		
		mockMvc.perform(post("/product")
				.content("{\r\n" + 
						"    \"name\": \"Camisa Regata\",\r\n" + 
						"    \"description\": \"Camisa regada de algodão\",\r\n" + 
						"    \"color\": \"azul\",\r\n" + 
						"    \"categoryId\": \"e8054f2d-6dfa-4231-8509-9574ea0193d4\"\r\n" + 
						"\r\n" + 
						"}")
				.contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isCreated())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id").value(ID.toString()));
		
	}
	
	@Test
	public void testGetProductById() throws Exception {
		when(productService.getProductById(Mockito.any(String.class))).thenReturn(CREATE_PRODUCT_RESPONSE);
		
		mockMvc.perform(get("/product/{id}", ID))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id").value(ID.toString()));
		
	}
}
