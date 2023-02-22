package com.productmanagement.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.productmanagement.models.Category;
import com.productmanagement.models.Product;
import com.productmanagement.repositories.CategoryRepository;
import com.productmanagement.repositories.ProductRepository;
import com.productmanagement.requests.CreateOrUpdateProductRequest;

@ExtendWith(SpringExtension.class)
public class ProductServiceImplTest {
	
	private static final UUID ID = UUID.randomUUID();
	private static final String CATEGORY_ID = UUID.randomUUID().toString();
	private static final String CATEGORY_NAME = "Vestidos";
	private static final String CATEGORY_DESCRIPTION = "Vestidos longos";
	private static final String NAME="Camisa regata";
	private static final String DESCRIPTION = "camisa gola v";
	private static final String COLOR = "verde";
	private static final Date CREATIONDATE=new Date();
	private static final Date LASTUPDATEDATE=new Date();
	private static final Category CATEGORY=new Category();
	
	private static final CreateOrUpdateProductRequest CREATE_PRODUCT_REQUEST = new CreateOrUpdateProductRequest(NAME, DESCRIPTION, COLOR, CATEGORY_ID);
	private static final Product CREATE_PRODUCT_RESPONSE = new Product(ID , NAME, DESCRIPTION, COLOR, CREATIONDATE, LASTUPDATEDATE, CATEGORY);
	
	private ProductRepository productRepository = Mockito.mock(ProductRepository.class);
		
	private CategoryRepository categoryRepository = Mockito.mock(CategoryRepository.class);
	
	private CategoryService categoryService = Mockito.mock(CategoryService.class);
	
	private ProductService productService = new ProductServiceImpl(productRepository, categoryRepository, categoryService);
	
	@BeforeEach
	private void setCategory() {
		CATEGORY.setId(UUID.fromString(CATEGORY_ID));
		CATEGORY.setName(CATEGORY_NAME);
		CATEGORY.setDescription(CATEGORY_DESCRIPTION);
		CATEGORY.setCreationDate(CREATIONDATE);
		CATEGORY.setLastUpdateDate(LASTUPDATEDATE);
	}
	
	@Test
	public void testCreate() {
		
		when(this.productRepository.save(Mockito.any())).thenReturn(CREATE_PRODUCT_RESPONSE);
		when(this.categoryRepository.findById(Mockito.any())).thenReturn(Optional.of(CATEGORY));
		
		Product result = this.productService.create(CREATE_PRODUCT_REQUEST);
		
		assertEquals(ID, result.getId());
	}
	
	@Test
	public void testUpdate() {
		
	}
	
	@Test
	public void testGetById() {
		when(this.productRepository.findById(Mockito.any())).thenReturn(Optional.of(CREATE_PRODUCT_RESPONSE));
		
		Product result = this.productService.getProductById(ID.toString());
		
		assertEquals(ID, result.getId());
	}
	
	@Test
	public void testGetProducts() {
		
		List<Product> products = new ArrayList<Product>();
		products.add(CREATE_PRODUCT_RESPONSE);
		
		when(this.productRepository.findByCategoryId(Mockito.any())).thenReturn(products);
		
		List<Product> result = this.productService.getProductsByCategoryId(UUID.fromString(CATEGORY_ID));
		
		assertEquals(products.contains(CREATE_PRODUCT_RESPONSE), result.contains(CREATE_PRODUCT_RESPONSE));
	}
	
	@Test
	public void testDelete() {
		
	}
	
	
}
