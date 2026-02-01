package com.arthurrocha01.api_java.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.arthurrocha01.api_java.domain.Item;

public interface ItemRepository {
	Page<Item> findAll( Pageable pageable);
	Item findById(Long id);
	Item save(Item item);
}