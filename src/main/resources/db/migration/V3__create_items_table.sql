CREATE TABLE items (
    id BIGSERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    id_category BIGINT NOT NULL,

    CONSTRAINT fk_items_category
        FOREIGN KEY (id_category)
        REFERENCES categories(id)
);