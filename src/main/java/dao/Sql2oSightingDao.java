package dao;

import models.Sighting;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oSightingDao implements SightingDao {
    private final Sql2o sql2o;

    public Sql2oSightingDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void addSighting(Sighting sighting) {
        String sql = "INSERT INTO sightings (animalId,location,rangerName) VALUES (:animalId,:location ,:rangerName)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(sighting)
                    .executeUpdate() //run it all
                    .getKey(); //int id is now the row number (row “key”) of db
            sighting.setId(id); //update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println("there was a problem adding the sighting");
        }
    }

    @Override
    public List<Sighting> getAllSightings() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM sightings") //raw sql
                    .executeAndFetch(Sighting.class); //fetch a list
        }
    }
    public List<Sighting> sortAllSightings() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM sightings ORDER BY createdAt DESC;") //raw sql
                    .executeAndFetch(Sighting.class); //fetch a list
        }
    }


    @Override
    public Sighting findSightingById(int id) {

        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM sightings WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Sighting.class); //fetch an individual item
        }
    }

    @Override
    public void update(int id, String newLocation, int newAnimalId, String newRangerName){
        String sql = "UPDATE sightings SET (location, animalId, rangerName) = (:location, :animalId,:rangerName) WHERE id=:id"; //raw sql
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("location", newLocation)
                    .addParameter("rangerName", newRangerName)
                    .addParameter("animalId", newAnimalId)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteSightingById(int id) {

        String sql = "DELETE from sightings WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void deleteAllSightings() {
        String sql = "DELETE from sightings *";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

}
