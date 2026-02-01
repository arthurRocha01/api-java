package com.arthurrocha01.api_java.application.command;

import java.math.BigDecimal;
import java.util.Optional;

public record PatchItemCommand(
    Long itemId,
    Optional<String> description,
    Optional<BigDecimal> price,
    Optional<Long> categoryId
) {}

