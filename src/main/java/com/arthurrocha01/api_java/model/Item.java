package com.arthurrocha01.api_java.model;

import java.math.BigDecimal;

public class Item {
	private final Long id;
	private final String description;
	private final BigDecimal price;
	private final Category category;
	
	public Item(Long id, String description, BigDecimal price, Category category) {
		this.id = id;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public Long getId() { return this.id; }
	public String getDescription() { return this.description; }
	public BigDecimal getPrice() { return this.price; }
	public Category getCategory() { return this.category; }
}