package models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SightingTest {
    @Test
    void objectInstantiatesCorrectly_True() {
        Sighting sighting = new Sighting(1,"Zone D","John Doe");
        assertTrue(sighting instanceof Sighting);
    }

    @Test
    void getName_returnsNameAttributeCorrectly_String() {
        Sighting sighting = new Sighting(1,"Zone D","John Doe");
        assertEquals( "Zone D", sighting.getLocation());
    }

    @Test
    void equals_comparesContents() {
        Sighting sighting = new Sighting(1,"Zone D","John Doe");
        Sighting sighting2 = new Sighting(1,"Zone D","John Doe");
        assertEquals(sighting, sighting2);
    }

    @Test
    void createdAt_returnDateCreatedCorrectly() {
        Sighting sighting = new Sighting(1,"Zone D","John Doe");
        LocalDate date = sighting.getCreatedAt();
        LocalDate now = LocalDate.now();
        assertEquals(now, date);
    }
}
