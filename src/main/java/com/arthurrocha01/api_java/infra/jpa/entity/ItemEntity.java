package com.arthurrocha01.api_java.infra.jpa.entity;

import java.math.BigDecimal;

import com.arthurrocha01.api_java.model.Item;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "items")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	private CategoryEntity category;

	public Item toModel() {
		return new Item(id, description, price, category.toModel());
	}
	
	public Long getId() { return this.id; }
	public String getDescription() { return this.description; }
	public BigDecimal getPrice() { return this.price; }
	public CategoryEntity getCategory() { return this.category; }
}