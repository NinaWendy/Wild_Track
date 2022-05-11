package dao;

import models.Sighting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Sql2oSightingDaoTest {
    private static Sql2oSightingDao sightingDao;
    private static Connection conn;


    @BeforeEach //(run once before running any tests in this file)
    public void setUp(){ //changed to static
        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker_test"; // connect to postgres test database
        Sql2o sql2o = new Sql2o(connectionString, "nina", "kabila");
        sightingDao = new Sql2oSightingDao(sql2o);
        conn = sql2o.open(); // open connection once before this test file is run
        System.out.println("Connection is open");
    }

    @AfterEach // run after every test
    public void tearDown() {
        System.out.println("clearing database");
        sightingDao.deleteAllSightings(); // clear all sightings after every test
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }

    @Test
    public void addingSightingSetsId(){
        Sighting sighting= new Sighting(1,"Zone A","Nina");
        int originalSightingId = sighting.getId();
        sightingDao.addSighting(sighting);
        assertNotEquals(originalSightingId, sighting.getId());
    }
    @Test
    public void existingSightingCanBeFoundById(){
        Sighting sighting= new Sighting(1,"Zone A","Nina");
        sightingDao.addSighting(sighting); //add to dao (takes care of saving)
        Sighting foundSighting = sightingDao.findSightingById(sighting.getId()); //retrieve
        assertEquals(sighting, foundSighting); //should be the same
    }
    @Test
    public void updateChangesSightingContent(){
        Sighting sighting= new Sighting(1,"Zone A","Nina");
        sightingDao.addSighting(sighting);
        sightingDao.update(sighting.getId(),"Zone C", 1,"Thee range");
        Sighting updatedSighting = sightingDao.findSightingById(sighting.getId());
        assertNotEquals(sighting.getRangerName(), updatedSighting.getRangerName());
    }
    @Test
    public void sightingIdIsReturnedCorrectly(){
        Sighting sighting= new Sighting(1,"Zone A","Nina");
        sightingDao.addSighting(sighting);
        int originalAnimalId = sighting.getAnimalId();
        assertEquals(originalAnimalId, sightingDao.findSightingById(sighting.getId()).getAnimalId());
    }
    @Test
    public void sort_rearrangesRecordsByDate(){

        Sighting sighting= new Sighting(1,"Zone A","Nina");
        Sighting sighting2= new Sighting(2,"Zone A","Nina");
        sightingDao.addSighting(sighting);
        sightingDao.addSighting(sighting2);
        sighting.setCreatedAt(LocalDate.of(2020, 11, 1));
        sighting2.setCreatedAt(LocalDate.now());
        sightingDao.sortAllSightings();
        assertEquals(1, sightingDao.getAllSightings().size()-1);
    }
}
