package com.arthurrocha01.api_java.infra.jpa;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.arthurrocha01.api_java.domain.Item;
import com.arthurrocha01.api_java.infra.jpa.entity.ItemEntity;
import com.arthurrocha01.api_java.repository.ItemRepository;

@Repository
public class JPAItemRepository implements ItemRepository{
	private final SpringItemJPARepository jpa;
	
	public JPAItemRepository(SpringItemJPARepository jpa) {
		this.jpa = jpa;
	}
	
	@Override
	public Page<Item> findAll(Pageable pageable) {
		Objects.requireNonNull(pageable, "O parâmetro pageable não pode ser nulo");
		return jpa.findAll(pageable).map(ItemEntity::toDomain);
	}

	@Override
	public Item findBySku(String sku) {
		Objects.requireNonNull(sku, "O parâmetro sku não pode ser nulo");
		ItemEntity entity = this.jpa.findBySku(sku).orElse(null);
		
		if (entity == null) {
			return null;
		}
		return entity.toDomain();
	}

	@Override
	public Item save(Item item) {
		ItemEntity entity = ItemEntity.fromDomain(item);
		ItemEntity saved = this.jpa.save(Objects.requireNonNull(entity));

		return saved.toDomain();
	}
}