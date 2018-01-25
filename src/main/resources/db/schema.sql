DROP TABLE owners
IF EXISTS;
DROP TABLE pets
IF EXISTS;
DROP TABLE pet_types
IF EXISTS;
DROP TABLE specialities
IF EXISTS;
DROP TABLE veterinarian_specialties
IF EXISTS;
DROP TABLE veterinarians
IF EXISTS;
DROP TABLE visits
IF EXISTS;

CREATE TABLE owners (
    id      VARCHAR(32)  NOT NULL,
    address VARCHAR(255) NOT NULL,
    name    VARCHAR(255) NOT NULL UNIQUE,
    phone   VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE pet_types (
    id   VARCHAR(32)  NOT NULL,
    name VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE pets (
    id          VARCHAR(32)  NOT NULL,
    birthday    TIMESTAMP    NOT NULL,
    name        VARCHAR(255) NOT NULL,
    owner_id    VARCHAR(32)  NOT NULL REFERENCES owners (id),
    pet_type_id VARCHAR(32)  NOT NULL REFERENCES pet_types (id),
    PRIMARY KEY (id)
);

CREATE TABLE veterinarians (
    id   VARCHAR(32)  NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE specialities (
    id   VARCHAR(32)  NOT NULL,
    name VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE veterinarian_specialties (
    veterinarian_id VARCHAR(32) NOT NULL REFERENCES veterinarians (id),
    specialty_id    VARCHAR(32) NOT NULL REFERENCES specialities (id),
    PRIMARY KEY (veterinarian_id, specialty_id)
);

CREATE TABLE visits (
    id          VARCHAR(32)  NOT NULL,
    date        TIMESTAMP    NOT NULL,
    description VARCHAR(255) NOT NULL,
    pet_id      VARCHAR(32)  NOT NULL REFERENCES pets (id),
    PRIMARY KEY (id)
);
