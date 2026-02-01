package com.arthurrocha01.api_java.controller.dto.request;

import java.math.BigDecimal;
import java.util.Optional;

import com.arthurrocha01.api_java.application.command.PatchItemCommand;

public record PatchItemRequest(
    Long id,
    Optional<String> description,
    Optional<BigDecimal> price,
    Optional<Long> categoryId
) {
    public PatchItemCommand toCommand() {
        return new PatchItemCommand(id, description, price, categoryId);
    }
}
