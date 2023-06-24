CREATE TABLE IF NOT EXISTS model
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    serial VARCHAR(120) NOT NULL,
    color VARCHAR(120) NOT NULL,
    size NUMERIC(10, 2) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    availability BOOLEAN NOT NULL,
    category VARCHAR(120),
    technology VARCHAR(120),
    capacity NUMERIC(4, 2),
    mode INT,
    device_id INT REFERENCES device(id) NOT NULL
);