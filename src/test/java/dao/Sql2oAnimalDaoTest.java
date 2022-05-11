package dao;

import models.Animal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Sql2oAnimalDaoTest {
    private static Sql2oAnimalDao animalDao;
//    private static Sql2oSightingDao sightingDao;
    private static Connection conn;

    @BeforeEach //(run once before any tests in this file)
    public void setUp(){ //changed to static
        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker_test"; // connect to postgres test database
        Sql2o sql2o = new Sql2o(connectionString, "nina", "kabila");//change this to your postgres username and password after cloning repository
        animalDao = new Sql2oAnimalDao(sql2o);
//        sightingDao = new Sql2oSightingDao(sql2o);
        conn = sql2o.open(); // open connection once before this test file is run
        System.out.println("Connection is open");
    }

    @AfterEach // run after every test
    public void tearDown() {
        System.out.println("clearing database");
        animalDao.deleteAllAnimals(); // clear all animals after every test
//        sightingDao.deleteAllSightings(); // clear all sightings after every test
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }
    @Test
    public void addAnimal_addingAnimalSetsId(){
        Animal animal= new Animal("Tiger");
        int originalAnimalId = animal.getId();
        animalDao.addAnimal(animal);
        assertNotEquals(originalAnimalId, animal.getId());
    }
    @Test
    public void findById_existingAnimalsCanBeFoundById(){
        Animal animal= new Animal("Tiger");
        animalDao.addAnimal(animal); //add to dao (takes care of saving)
        Animal foundAnimal = animalDao.findAnimalById(animal.getId()); //retrieve
        assertEquals(animal, foundAnimal);
    }
    @Test
    public void getAllAnimals_returnsListOfAllAnimals(){
        Animal animal= new Animal("Tiger");
        Animal animal2= new Animal("Rhino");
        animalDao.addAnimal(animal); //add to dao (takes care of saving)
        animalDao.addAnimal(animal2); //add to dao (takes care of saving)
        List<Animal> list = animalDao.getAllAnimals();
        assertEquals(2, list.size());
    }
    @Test
    public void deleteAllAnimals_removesListOfAllAnimals(){
        Animal animal= new Animal("Tiger");
        Animal animal2= new Animal("Rhino");
        animalDao.addAnimal(animal); //add to dao (takes care of saving)
        animalDao.addAnimal(animal2); //add to dao (takes care of saving)
        animalDao.deleteAllAnimals();
        List<Animal> list = animalDao.getAllAnimals();
        assertEquals(0, list.size());
    }


//    @Test
//    public void getAllSightingsForAnimalReturnsSightingsCorrectly(){
//        Animal animal= new Animal("White Tiger");
//        int animalId = animal.getId();
//        Sighting newSighting = new Sighting(animalId,"Zone B","Nina Grey");
//        Sighting newSighting2 = new Sighting(animalId,"Zone C","Grey");
//        Sighting newSighting3 = new Sighting(animalId,"Zone A","Nina");
//        animalDao.add(newSighting);
//        animalDao.add(newSighting2);
////        we are not adding sighting 3 so that we can test things precisely.
//        assertEquals(2, animalDao.getAllSightingsByAnimal(animalId).size());
//        assertTrue(animalDao.getAllSightingsByAnimal(animalId).contains(newSighting));
//        assertTrue(animalDao.getAllSightingsByAnimal(animalId).contains(newSighting2));
//        assertFalse(animalDao.getAllSightingsByAnimal(animalId).contains(newSighting3));
//    }
}
