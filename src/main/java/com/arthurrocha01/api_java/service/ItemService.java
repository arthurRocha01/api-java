package com.arthurrocha01.api_java.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.arthurrocha01.api_java.model.Item;
import com.arthurrocha01.api_java.repository.ItemRepository;
import com.arthurrocha01.api_java.service.command.PatchItemCommand;
import com.arthurrocha01.api_java.service.command.UpdateItemComand;

import jakarta.transaction.Transactional;

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

	public Item getItemById(Long id) {
		return this.repository.findById(id);
	}

	@Transactional
	public Item updateItem(Long id, UpdateItemComand cmd) {
		Item item = this.repository.findById(id);

		item.changePrice(cmd.price());

		return this.repository.save(item);
	}

	@Transactional
	public void patchItem(Long id, PatchItemCommand cmd) {
		Item item = this.repository.findById(id);

		cmd.price().ifPresent(item::changePrice);

		this.repository.save(item);
	}
}