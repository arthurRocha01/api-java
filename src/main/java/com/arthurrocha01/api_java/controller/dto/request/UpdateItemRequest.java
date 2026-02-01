package com.arthurrocha01.api_java.controller.dto.request;

import java.math.BigDecimal;

import com.arthurrocha01.api_java.application.command.UpdateItemComand;

public record UpdateItemRequest(
    String description,
    BigDecimal price,
    Long categoryId
) {
    public UpdateItemComand toCommand() {
        return new UpdateItemComand(description, price, categoryId);
    }
}
