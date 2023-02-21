package com.productmanagement.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="product")
public class Product {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String name;
	
	/*
	 * @Column(columnDefinition = "category_id") private UUID categoryId;
	 */
	private String description;
	private String color;
	private Date creationDate;
	private Date lastUpdateDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	@JsonIgnoreProperties(value = {"products", "hibernateLazyInitializer"})
	private Category category;
	
	
}
