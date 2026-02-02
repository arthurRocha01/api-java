package com.arthurrocha01.api_java.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arthurrocha01.api_java.application.ItemService;
import com.arthurrocha01.api_java.controller.dto.request.PatchItemRequest;
import com.arthurrocha01.api_java.controller.dto.request.UpdateItemRequest;
import com.arthurrocha01.api_java.domain.Item;

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

	@GetMapping("/{sku}")
	public ResponseEntity<Item> getItemById(@PathVariable String sku) {
		return ResponseEntity.ok(
			this.service.getItemById(sku)
		);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Item> update(
		@PathVariable String sku,
		@RequestBody UpdateItemRequest request
	) {
		Item updatedItem = this.service.updateItem(sku, request.toCommand());
		return ResponseEntity.ok(updatedItem);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Void> patch(
		@PathVariable String sku,
		@RequestBody PatchItemRequest request
	) {
		this.service.patchItem(sku, request.toCommand());
		return ResponseEntity.noContent().build();
	}
}