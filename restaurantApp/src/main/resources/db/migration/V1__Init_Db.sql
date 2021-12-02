CREATE TABLE IF NOT EXISTS customer(
    id BIGINT NOT NULL,
    name VARCHAR(250),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS orders(
    id BIGINT NOT NULL,
    registration_time TIMESTAMP,
    status VARCHAR(250),
    price float,
    customer_id BIGINT,
    PRIMARY KEY(id),
    CONSTRAINT customer_id_orders_fk FOREIGN KEY(customer_id) REFERENCES customer(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS category(
    id BIGINT NOT NULL,
    name VARCHAR(250),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS product(
    id BIGINT NOT NULL,
    name_of_food VARCHAR(250),
    price float,
    category_id BIGINT,
    PRIMARY KEY(id),
    CONSTRAINT category_id_product_fk FOREIGN KEY(category_id) REFERENCES category(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS order_product(
    order_id BIGINT,
    product_id BIGINT,
    quantity INTEGER,
    CONSTRAINT order_id_order_product_fk FOREIGN KEY(order_id) REFERENCES orders(id) ON DELETE CASCADE,
    CONSTRAINT product_id_order_product_fk FOREIGN KEY(product_id) REFERENCES product(id) ON DELETE CASCADE,
    PRIMARY KEY(order_id,product_id)
);

CREATE SEQUENCE IF NOT EXISTS HIBERNATE_SEQUENCE;
