CREATE TABLE shop_item (
    id BIGSERIAL PRIMARY KEY,
    game_name TEXT NOT NULL,
    release_year INT NOT NULL,
    cost DECIMAL NOT NULL,
    unique (game_name)
);