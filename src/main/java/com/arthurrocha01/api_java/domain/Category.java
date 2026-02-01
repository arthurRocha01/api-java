package com.arthurrocha01.api_java.domain;

public class Category {
    private final Long id;
    private final String name;
    private final String slug;

    public Category(Long id, String name, String slug) {
        this.id = id;
        this.name = name;
        this.slug = slug;
    }

    public Long getId() { return this.id; }
    public String getName() { return this.name; }
    public String getSlug() { return this.slug; }
}
