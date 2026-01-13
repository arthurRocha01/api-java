package com.arthurrocha01.api_java.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Item {
	private final UUID id;
	private final String description;
	private final BigDecimal price;
	
	public Item(UUID id, String description, BigDecimal price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}
	
	public UUID getId() { return this.id; }
	public String getDescription() { return this.description; }
	public BigDecimal getPrice() { return this.price; }

}