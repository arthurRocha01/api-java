package com.arthurrocha01.api_java.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arthurrocha01.api_java.model.Item;
import com.arthurrocha01.api_java.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

	private final ItemService service;
	
	public ItemController(ItemService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<Page<Item>> list(
		@RequestParam(defaultValue = "0") int page,
		@RequestParam(defaultValue = "10") int size
	) {
		Page<Item> list = this.service.listItems(page, size);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable Long id) {
		return ResponseEntity.ok(
			this.service.getItemById(id)
		);
	}
}