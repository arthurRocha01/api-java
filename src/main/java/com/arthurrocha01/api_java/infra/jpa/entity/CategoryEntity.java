package com.arthurrocha01.api_java.infra.jpa.entity;

import com.arthurrocha01.api_java.domain.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String slug;

    public Category toDomain() {
        return new Category(id, name, slug);
    }

    public static CategoryEntity fromDomain(Category category) {
        CategoryEntity e = new CategoryEntity();
        e.id = category.getId();
        e.name = category.getName();
        return e;
    }

    public Long getId() { return this.id; }
    public String getName() { return this.name; }
    public String getSlug() { return this.slug; }
}
