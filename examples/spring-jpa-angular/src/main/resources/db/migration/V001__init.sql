CREATE TABLE person (
  id BIGINT PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL,
  date_of_birth DATE,
  gender VARCHAR(10) NOT NULL,
  weight DOUBLE,
  active BOOLEAN
);

CREATE SEQUENCE hibernate_sequence;

