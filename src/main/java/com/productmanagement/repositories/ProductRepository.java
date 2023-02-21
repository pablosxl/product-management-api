package com.productmanagement.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productmanagement.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>{
	
	@Query(value = "from Product where category_id=?1")
	public List<Product> findByCategoryId(UUID categoryId);
}
