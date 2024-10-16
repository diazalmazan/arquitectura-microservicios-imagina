
CREATE TABLE IF NOT EXISTS INVENTORY (
                            id BIGSERIAL PRIMARY KEY,
                            product_id BIGINT,
                            quantity INT NOT NULL
);
