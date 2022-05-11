package dao;

import models.EndangeredAnimal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oEndangeredAnimalDao implements EndangeredAnimalDao{
    private final Sql2o sql2o;

    public Sql2oEndangeredAnimalDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void addEndangeredAnimal(EndangeredAnimal endangeredAnimal) {
        String sql = "INSERT INTO animals (name,health,age) VALUES (:name, :health, :age)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(endangeredAnimal)
                    .executeUpdate() //run it all
                    .getKey(); //int id is now the row number (row “key”) of db
            endangeredAnimal.setId(id); //update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println("there was a problem adding the endangered animal");
        }
    }

    @Override
    public List<EndangeredAnimal> getAllEndangeredAnimals() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM animals") //raw sql
                    .executeAndFetch(EndangeredAnimal.class); //fetch a list
        }
    }

    @Override
    public EndangeredAnimal findEndangeredAnimalById(int id) {

        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM animals WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(EndangeredAnimal.class); //fetch an individual item
        }
    }
    @Override
    public void deleteEndangeredAnimalById(int id) {

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
    public void deleteAllEndangeredAnimals() {

        String sql = "DELETE from animals *";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
