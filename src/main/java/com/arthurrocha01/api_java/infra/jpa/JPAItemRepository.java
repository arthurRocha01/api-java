package com.arthurrocha01.api_java.infra.jpa;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.arthurrocha01.api_java.infra.jpa.entity.ItemEntity;
import com.arthurrocha01.api_java.model.Item;
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
		return jpa.findAll(pageable).map(ItemEntity::toModel);
	}

	@Override
	public Item findById(Long id) {
		Objects.requireNonNull(id, "O parâmetro id não pode ser nulo");
		ItemEntity entity = this.jpa.findById(id).orElse(null);
		
		if (entity == null) {
			return null;
		}
		return entity.toModel();
	}
}