package com.arthurrocha01.api_java.repository;

import java.util.List;

import com.arthurrocha01.api_java.model.Item;

public interface ItemRepository {
	List<Item> findAll();
}