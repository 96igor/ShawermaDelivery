CREATE TABLE users(
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      email VARCHAR(255) UNIQUE NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      telegram VARCHAR(255),
                      phone VARCHAR(255),
                      address VARCHAR(255)
);