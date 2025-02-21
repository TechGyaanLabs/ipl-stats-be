CREATE TABLE IF NOT EXISTS app_user (
    id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password varchar(255) NOT NULL,
    email varchar(255),
    full_name VARCHAR(255)
);

