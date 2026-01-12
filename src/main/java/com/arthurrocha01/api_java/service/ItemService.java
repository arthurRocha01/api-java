package com.arthurrocha01.api_java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arthurrocha01.api_java.model.item.Item;
import com.arthurrocha01.api_java.repository.ItemRepository;

@Service
public class ItemService {
	
	private final ItemRepository repository;
	
	public ItemService(ItemRepository repository) {
		this.repository = repository;
	}
	
	public List<Item> listItems() {
		return this.repository.findAll();
	}
}
