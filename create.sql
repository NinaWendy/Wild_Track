CREATE DATABASE wildlife_tracker;
\c wildlife_tracker;

CREATE TABLE  IF NOT EXISTS animals(
   id SERIAL PRIMARY KEY,
   name VARCHAR, endangered BOOLEAN);
CREATE TABLE IF NOT EXISTS sightings(
    id SERIAL PRIMARY KEY,
    animalId INTEGER,
    location VARCHAR,
    rangerName VARCHAR,
    createdAt TIMESTAMP);
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;