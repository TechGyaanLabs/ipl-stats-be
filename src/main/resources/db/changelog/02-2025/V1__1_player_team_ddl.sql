CREATE TABLE IF NOT EXISTS team_details (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    total_amount float NOT NULL,
    remaining_amount float NOT NULL,
    label VARCHAR(50) NOT NULL,
    total_players int NOT NULL,
    overseas_players int NOT NULL
);

CREATE TABLE IF NOT EXISTS player (
    id uuid PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    country VARCHAR(100) NOT NULL,
    team VARCHAR(100) NOT NULL,
    price float NOT NULL,
    team_id uuid,
    CONSTRAINT fk_team_player FOREIGN KEY (team_id) REFERENCES team_details (id)
);