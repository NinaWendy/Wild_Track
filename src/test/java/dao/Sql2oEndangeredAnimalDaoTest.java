package dao;

import models.Animal;
import models.EndangeredAnimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Sql2oEndangeredAnimalDaoTest {
    private static Sql2oAnimalDao animalDao;
    private static Sql2oEndangeredAnimalDao endangeredAnimalDao;
    //    private static Sql2oSightingDao sightingDao;
    private static Connection conn;

    @BeforeEach //(run once before any tests in this file)
    public void setUp(){ //changed to static
        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker_test"; // connect to postgres test database
        Sql2o sql2o = new Sql2o(connectionString, "nina", "kabila");//change this to your postgres username and password after cloning repository
        animalDao = new Sql2oAnimalDao(sql2o);
        endangeredAnimalDao = new Sql2oEndangeredAnimalDao(sql2o);
//        sightingDao = new Sql2oSightingDao(sql2o);
        conn = sql2o.open(); // open connection once before this test file is run
        System.out.println("Connection is open");
    }

    @AfterEach // run after every test
    public void tearDown() {
        System.out.println("clearing database");
        animalDao.deleteAllAnimals(); // clear all animals after every test
        endangeredAnimalDao.deleteAllEndangeredAnimals(); // clear all animals after every test
//        sightingDao.deleteAllSightings(); // clear all sightings after every test
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }
    @Test
    public void addAnimal_addingAnimalSetsId(){
        EndangeredAnimal endangeredAnimal= new EndangeredAnimal("Tiger","Healthy","Newborn");
        int originalEndangeredAnimalId = endangeredAnimal.getId();
        endangeredAnimalDao.addEndangeredAnimal(endangeredAnimal);
        assertNotEquals(originalEndangeredAnimalId, endangeredAnimal.getId());
    }
    @Test
    public void findById_existingAnimalsCanBeFoundById(){
        EndangeredAnimal endangeredAnimal= new EndangeredAnimal("Tiger","Healthy","Newborn");
        endangeredAnimalDao.addEndangeredAnimal(endangeredAnimal);//add to dao (takes care of saving)
        EndangeredAnimal foundEndangeredAnimal = endangeredAnimalDao.findEndangeredAnimalById(endangeredAnimal.getId()); //retrieve
        assertEquals(endangeredAnimal, foundEndangeredAnimal);
    }
    @Test
    public void getAllAnimals_returnsListOfAllAnimals(){
        EndangeredAnimal endangeredAnimal= new EndangeredAnimal("Tiger","Healthy","Newborn");
        EndangeredAnimal endangeredAnimal2= new EndangeredAnimal("Rhino","Healthy","Newborn");
        endangeredAnimalDao.addEndangeredAnimal(endangeredAnimal);
        endangeredAnimalDao.addEndangeredAnimal(endangeredAnimal2);
        List<EndangeredAnimal> list = endangeredAnimalDao.getAllEndangeredAnimals();
        assertEquals(2, list.size());
    }
    @Test
    public void deleteAllAnimals_removesListOfAllAnimals(){
        EndangeredAnimal endangeredAnimal= new EndangeredAnimal("Tiger","Healthy","Newborn");
        EndangeredAnimal endangeredAnimal2= new EndangeredAnimal("Tiger","Healthy","Newborn");
        endangeredAnimalDao.addEndangeredAnimal(endangeredAnimal);
        endangeredAnimalDao.addEndangeredAnimal(endangeredAnimal2);
        endangeredAnimalDao.deleteAllEndangeredAnimals();
        List<EndangeredAnimal> list = endangeredAnimalDao.getAllEndangeredAnimals();
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
