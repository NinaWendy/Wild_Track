package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EndangeredAnimalTest {
    @Test
    void objectInstantiatesCorrectly_True() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Tiger","Healthy","Adult");
        assertTrue(endangeredAnimal instanceof EndangeredAnimal);
    }

    @Test
    void getHealth_returnsHealthAttributeCorrectly_String() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Tiger","Healthy","Adult");
        assertEquals( "Healthy", endangeredAnimal.getHealth());
    }

    @Test
    void equals_comparesContents() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Tiger","Healthy","Adult");
        EndangeredAnimal endangeredAnimal2 = new EndangeredAnimal("Tiger","Healthy","Adult");
        assertEquals(endangeredAnimal, endangeredAnimal2);
    }

}
