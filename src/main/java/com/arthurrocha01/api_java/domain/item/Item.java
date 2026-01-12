package com.arthurrocha01.api_java.domain.item;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.sql.results.DomainResultCreationException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "items")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private String description;
	private BigDecimal price;
	
	public Item(String description, BigDecimal price) {
		if (description == null || description.isBlank()) throw new DomainResultCreationException("A descrição é obrigatória para a criação do Item.");
		if (price == null || price.compareTo(BigDecimal.ZERO) > 0) throw new DomainResultCreationException("O preço é inválido para Item.");
		
		this.description = description;
		this.price = price;
	} 

}
