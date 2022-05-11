package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalTest {
    @Test
    void objectInstantiatesCorrectly_True() {
        Animal animal = new Animal("Tiger");
        assertTrue(animal instanceof Animal);
    }

    @Test
    void getName_returnsNameAttributeCorrectly_String() {
        Animal animal = new Animal("Tiger");
        assertEquals( "Tiger", animal.getName());
    }

    @Test
    void equals_comparesContents() {
        Animal animal = new Animal("Tiger");
        Animal animal2 = new Animal("Tiger");
        assertEquals(animal, animal2);
    }
}
