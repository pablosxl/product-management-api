	package com.productmanagement.models;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;

public class ProductTest {
	
	private static final UUID ID = UUID.randomUUID();
	private static final String NAME="Camisa regata";
	private static final String DESCRIPTION = "camisa gola v";
	private static final String COLOR = "verde";
	private static final Date CREATIONDATE=new Date();
	private static final Date LASTUPDATEDATE=new Date();
	private static final Category CATEGORY=new Category();
	
	private final Product product;
	
	
	public ProductTest() {
		this.product = new Product();
	}
	
	@Test
	public void testId() {
		this.product.setId(ID);
		
		assertEquals(ID, this.product.getId());
	}
	
	@Test
	public void testName() {
		
		this.product.setName(NAME);
		
		assertEquals(NAME, product.getName());
	}
	
	@Test
	public void testDescription() {
		this.product.setDescription(DESCRIPTION);
		
		assertEquals(DESCRIPTION, product.getDescription());
	}
	
	@Test
	public void testColor() {
		this.product.setColor(COLOR);
		
		assertEquals(COLOR, product.getColor());
		
	}
	
	@Test
	public void testCreationDate() {
		this.product.setCreationDate(CREATIONDATE);
		
		assertEquals(CREATIONDATE, product.getCreationDate());
		
	}
	
	@Test
	public void testLastUpdateDate() {
		this.product.setLastUpdateDate(LASTUPDATEDATE);
		
		assertEquals(LASTUPDATEDATE, product.getLastUpdateDate());
	}
	
	@Test
	public void testCategory() {
		
		this.product.setCategory(CATEGORY);
		
		assertEquals(CATEGORY, product.getCategory());
		
	}
	
}
