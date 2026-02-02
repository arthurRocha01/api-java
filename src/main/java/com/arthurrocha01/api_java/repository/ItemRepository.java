package com.arthurrocha01.api_java.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.arthurrocha01.api_java.domain.Item;

public interface ItemRepository {
	Page<Item> findAll( Pageable pageable);
	Item findBySku(String sku);
	Item save(Item item);
}