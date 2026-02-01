package com.arthurrocha01.api_java.service.command;

import java.math.BigDecimal;

public record UpdateItemComand (
    String description,
    BigDecimal price,
    Long categoryId
) {
    public UpdateItemComand {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia");
        }

        if (price == null) {
            throw new IllegalArgumentException("Preço não pode ser nulo");
        }

        if (categoryId == null) {
            throw new IllegalArgumentException("CategoryId não pode ser nulo");
        }
    }
}
