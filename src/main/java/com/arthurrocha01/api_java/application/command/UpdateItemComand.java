package com.arthurrocha01.api_java.application.command;

import java.math.BigDecimal;

public record UpdateItemComand (
    String description,
    Integer quantity,
    BigDecimal price,
    Long categoryId
) {
    public UpdateItemComand {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia");
        }

        if (quantity == null) {
            throw new IllegalArgumentException("Quantity não pode ser nulo");
        }

        if (price == null) {
            throw new IllegalArgumentException("Preço não pode ser nulo");
        }

        if (categoryId == null) {
            throw new IllegalArgumentException("CategoryId não pode ser nulo");
        }
    }
}
