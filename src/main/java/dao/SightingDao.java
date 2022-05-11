package dao;

import models.Sighting;

import java.util.List;

public interface SightingDao {
    // list all Sightings
    List<Sighting> getAllSightings();

    // create a new Sighting
    void addSighting(Sighting sighting);

    // get a specific Sighting
    Sighting findSightingById(int id);

    // Delete a Sighting
    void deleteSightingById( int id);

    //update
    void update(int id, String location, int animalId,String rangeName);

    //Delete all Sightings
    void deleteAllSightings();
}
