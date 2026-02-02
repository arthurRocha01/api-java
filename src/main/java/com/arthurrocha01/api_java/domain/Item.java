package com.arthurrocha01.api_java.domain;

import java.math.BigDecimal;

public class Item {
	private Long id;
	private String sku;
	private String description;
	private Integer quantity;
	private BigDecimal price;
	private Category category;
	
	public Item(Long id, String sku, String description, Integer quantity, BigDecimal price, Category category) {
		this.id = id;
		this.sku = sku;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}

	public void changePrice(BigDecimal newPrice) {
		this.price = newPrice;
	}

	public void changeQuantity(Integer newQuantity) {
		this.quantity = newQuantity;
	}

	public Long getId() { return this.id; }
	public String getSku() { return this.sku; }
	public String getDescription() { return this.description; }
	public Integer getQuantity() { return this.quantity; }
	public BigDecimal getPrice() { return this.price; }
	public Category getCategory() { return this.category; }
}