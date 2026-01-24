CREATE TABLE link_table
(
    id_link BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    url_original VARCHAR(255) UNIQUE NOT NULL,
    url_shortened VARCHAR(50) UNIQUE,
    data_expiration TIMESTAMP NOT NULL
)