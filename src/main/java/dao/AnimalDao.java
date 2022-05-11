package dao;

import models.Animal;

import java.util.List;

public interface AnimalDao {

    // list all Animals
    List<Animal> getAllAnimals();

    // create a new Animal
    void addAnimal(Animal animal);

    // get a specific Animal
    Animal findAnimalById(int id);

    // Delete an animal
    void deleteAnimalById( int id);


    //Delete all animals
    void deleteAllAnimals();

//    List<Sighting> getAllSightingsByAnimal(int animalId);

}
