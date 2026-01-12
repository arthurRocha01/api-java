package com.arthurrocha01.api_java.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthurrocha01.api_java.model.item.Item;
import com.arthurrocha01.api_java.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

	private final ItemService service;
	
	public ItemController(ItemService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Item> list() {
		return this.service.listItems();
	}
}
