CREATE TABLE IF NOT EXISTS Run (
    id INT NOT NULL,
    title VARCHAR(55) NOT NULL,
    started_on TIMESTAMP NOT NULL,
    finished_on TIMESTAMP NOT NULL,
    km INT NOT NULL,
    location VARCHAR(55) NOT NULL,
    PRIMARY KEY(id)

);