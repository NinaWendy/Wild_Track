package dao;

import models.Animal;
import models.Sighting;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oAnimalDao implements AnimalDao{
    private final Sql2o sql2o;

    public Sql2oAnimalDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void addAnimal(Animal animal) {
        String sql = "INSERT INTO animals (name, health,age) VALUES (:name, :health, :age)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(animal)
                    .executeUpdate() //run it all
                    .getKey(); //int id is now the row number (row “key”) of db
            animal.setId(id); //update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println("there was a problem adding the animal");
        }
    }

    @Override
    public List<Animal> getAllAnimals() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM animals") //raw sql
                    .executeAndFetch(Animal.class); //fetch a list
        }
    }

    @Override
    public Animal findAnimalById(int id) {

        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM animals WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Animal.class); //fetch an individual item
        }
    }
    @Override
    public void deleteAnimalById(int id) {

        String sql = "DELETE from animals WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void deleteAllAnimals() {

        String sql = "DELETE from animals *";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Sighting> getAllSightingsByAnimal(int animalId) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM sightings WHERE animalId = :animalId")
                    .addParameter("animalId", animalId)
                    .executeAndFetch(Sighting.class);
        }
    }
    public void add(Sighting sighting) {
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
}
