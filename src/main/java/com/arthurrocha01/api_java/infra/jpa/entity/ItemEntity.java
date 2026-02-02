package com.arthurrocha01.api_java.infra.jpa.entity;

import java.math.BigDecimal;

import com.arthurrocha01.api_java.domain.Item;

import jakarta.persistence.Column;
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

	@Column(name = "sku", unique = true, nullable = false)
	private String sku;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "price", nullable = false)
	private BigDecimal price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	private CategoryEntity category;

	public Item toDomain() {
		return new Item(
			id,
			sku,
			description,
			quantity,
			price,
			category.toDomain()
		);
	}

	public static ItemEntity fromDomain(Item item) {
		ItemEntity e = new ItemEntity();
		e.id = item.getId();
		e.sku = item.getSku();
		e.description = item.getDescription();
		e.quantity = item.getQuantity();
		e.price = item.getPrice();
		e.category = CategoryEntity.fromDomain(item.getCategory());
		return e;
	}
}