package com.arthurrocha01.api_java.infra.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.arthurrocha01.api_java.model.Item;
import com.arthurrocha01.api_java.repository.ItemRepository;

@Repository
public class JPAItemRepository implements ItemRepository{
	private final SpringItemJPARepository jpa;
	
	public JPAItemRepository(SpringItemJPARepository jpa) {
		this.jpa = jpa;
	}
	
	@Override
	public List<Item> findAll() {
		return jpa.findAll()
				.stream()
				.map(e -> new Item(
						e.getId(),
						e.getDescription(),
						e.getPrice()
						))
				.toList();
	}
}