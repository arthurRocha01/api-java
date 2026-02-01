package com.arthurrocha01.api_java.domain;

import java.math.BigDecimal;

public class Item {
	private Long id;
	private String description;
	private BigDecimal price;
	private Category category;
	
	public Item(Long id, String description, BigDecimal price, Category category) {
		this.id = id;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public void changePrice(BigDecimal newPrice) {
		this.price = newPrice;
	}

	public Long getId() { return this.id; }
	public String getDescription() { return this.description; }
	public BigDecimal getPrice() { return this.price; }
	public Category getCategory() { return this.category; }
}