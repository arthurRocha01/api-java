package com.arthurrocha01.api_java.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.arthurrocha01.api_java.model.Item;
import com.arthurrocha01.api_java.repository.ItemRepository;

@Service
public class ItemService {
	
	private final ItemRepository repository;
	
	public ItemService(ItemRepository repository) {
		this.repository = repository;
	}
	
	public Page<Item> listItems(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("description").ascending());
		return this.repository.findAll(pageRequest);
	}
}