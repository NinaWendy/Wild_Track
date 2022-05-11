import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

//        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker";//connect to wildlife_tracker, not wildlife_tracker_test!
//        Sql2o sql2o = new Sql2o(connectionString, "nina", "kabila");
//        Sql2oSightingDao sightingDao = new Sql2oSightingDao(sql2o);
//        Sql2oAnimalDao animalDao = new Sql2oAnimalDao(sql2o);,,

        //Home page
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //ANIMAL
        //get: show a form to create a new animal
        get("/animals/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process a form to create a new animal
        post("/animals/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//            String name = req.queryParams("name");
//            String health = req.queryParams("health");
//            String age = req.queryParams("age");
//            Animal newAnimal = new Animal(name, health, age);
//            animalDao.addAnimal(newAnimal);
//            List<Animal> animals = animalDao.getAllAnimals();
//            model.put("animals", animals);
            return new ModelAndView(model,"animals.hbs");
        }, new HandlebarsTemplateEngine());

         //get: show a form to update a category
        get("/animal/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//            Animal animal = animalDao.findAnimalById(Integer.parseInt(req.params("id")));
//            model.put("animal", animal);
//            model.put("animals", animalDao.getAllAnimals());
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());
//
//        //post: process a form to update a category
//        post("/categories/:id", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfCategoryToEdit = Integer.parseInt(req.params("id"));
//            String newName = req.queryParams("newCategoryName");
//            animalDao.update(idOfCategoryToEdit, newName);
//            res.redirect("/");
//            return null;
//        }, new HandlebarsTemplateEngine());


        //show all animals
        get("/animals", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//            List<Animal> animals = animalDao.getAllAnimals();
//            model.put("animals", animals);
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete all animals
        get("/animals/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//            animalDao.deleteAllAnimals();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //SIGHTINGS
        //get: show a form to create a new sighting
        get("/sightings/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process a form to create a new category
        post("/sightings/new", (req, res) -> { //new
            Map<String, Object> model = new HashMap<>();
//            String location = req.queryParams("location");
//            String rangerName = req.queryParams("rangerName");
//            int animalId = Integer.parseInt(req.queryParams("animalId"));
//            LocalDate createdAt = LocalDate.parse(req.queryParams("creadtedAt"));
//            Sighting newSighting = new Sighting(animalId,location,rangerName);
//            sightingDao.addSighting(newSighting);
//            List<Sighting> sighting = sightingDao.getAllSightings();
//            model.put("sightings", sighting);
//            model.put("createdAt", createdAt);
            return new ModelAndView(model,"sightings.hbs");
        }, new HandlebarsTemplateEngine());

          //get: show a form to update a task
        get("/sightings/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//            List<Animal> allAnimals = animalDao.getAllAnimals();
//            model.put("categories", allAnimals);
//            Sighting sighting = sightingDao.findById(req.params("id"));
//            model.put("task", sighting);
//            model.put("editTask", true);
            return new ModelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process a form to update a sighting
        post("/sightings/:id", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int sightingToEditId = Integer.parseInt(req.params("id"));
//            String newRangerName = req.queryParams("rangerName");
//            int newAnimalId = Integer.parseInt(req.queryParams("animalId"));
//            sightingDao.update(sightingToEditId, newRangerName, newAnimalId);
//            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //show all sightings
        get("/sightings", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//            List<Sighting> sightings = sightingDao.getAllSightings();
//            model.put("sightings", sightings);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());


        //RANGERS
        //get: show a form to create a new ranger
        get("/rangers/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//            List<Ranger> list = req.session().attribute("Rangers");
//            model.put("Rangers", list);
            return new ModelAndView(model,"ranger-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process a form to create a new ranger
        post("/rangers/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
//            String rangerName = request.queryParams("rangerName");
//            int contact = Integer.parseInt(request.queryParams("contact"));
//            String badgeNo = request.queryParams("badgeNo");
//            List<Ranger> list = request.session().attribute("Rangers");
//            Ranger ranger = new Ranger(rangerName,contact, badgeNo);
//            ranger.addRanger(list, ranger);
//            List<Ranger> updatedRangers = ranger.getRangerList();
//            request.session().attribute("Rangers", updatedRangers);
//            model.put("Rangers", updatedRangers);
            return new ModelAndView(model, "rangers.hbs");
        }, new HandlebarsTemplateEngine());

        //show all rangers
        get("/rangers", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//            List<Ranger> rangers =  new ArrayList<>();
//            model.put("rangers", rangers);
            return new ModelAndView(model, "rangers.hbs");
        }, new HandlebarsTemplateEngine());

        //get a specific animal (and the sightings it contains)
        get("/animals/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//            int idOfAnimalToFind = Integer.parseInt(req.params("id")); //new
//            Animal foundAnimal = animalDao.findAnimalById(idOfAnimalToFind);
//            model.put("animal", foundAnimal);
//            List<Sighting> allSightingsForAnimal = animalDao.getAllSightingsByAnimal(idOfAnimalToFind);
//            model.put("sightings", allSightingsForAnimal);
//            model.put("animals", animalDao.getAllAnimals());
            return new ModelAndView(model, "animal-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to create a new sighting of an animal
        get("/animals/:id/sightings/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animal-sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process a form to create a new sightings of an animal
        post("/animals/:id/sightings/new", (req, res) -> { //new
            Map<String, Object> model = new HashMap<>();
//            String location = req.queryParams("location");
//            String rangerName = req.queryParams("rangerName");
//            int animalId = Integer.parseInt(req.queryParams("animalId"));
//            Sighting newSighting = new Sighting(animalId,location,rangerName);
//            sightingDao.addSighting(newSighting);
//            animalDao.add(newSighting);
//            List<Sighting> list = animalDao.getAllSightingsByAnimal(animalId);
//            List<Animal> animals = animalDao.getAllAnimals();
//            model.put("sightings", list);
            return new ModelAndView(model,"animal-detail.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
