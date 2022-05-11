package dao;

import models.EndangeredAnimal;

import java.util.List;

public interface EndangeredAnimalDao {
    // list all endangered animals
    List<EndangeredAnimal> getAllEndangeredAnimals();

    // create a new endangered animal
    void addEndangeredAnimal(EndangeredAnimal endangeredAnimal);

    // get a specific endangered animal
    EndangeredAnimal findEndangeredAnimalById(int id);

    // Delete an endangered animal
    void deleteEndangeredAnimalById( int id);


    //Delete all endangered animals
    void deleteAllEndangeredAnimals();

}
