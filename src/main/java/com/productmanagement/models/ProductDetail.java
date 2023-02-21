package com.productmanagement.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "product_detail")
@Data
@AllArgsConstructor
public class ProductDetail {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	private String color;
	private String size;
	private Date creationDate;
	private Date lastUpdateDate;
	
	@OneToOne
	@JoinColumn(name="productId")
	private Product product;
}
