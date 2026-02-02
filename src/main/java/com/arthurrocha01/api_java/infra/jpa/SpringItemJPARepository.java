package com.arthurrocha01.api_java.infra.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthurrocha01.api_java.infra.jpa.entity.ItemEntity;

public interface SpringItemJPARepository extends JpaRepository<ItemEntity, Long> {
    Optional<ItemEntity> findBySku(String sku);
}