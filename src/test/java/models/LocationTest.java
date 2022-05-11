package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocationTest {
    @Test
    void instantiatesCorrectly_True() {
        Location location = new Location("Zone F");
        assertTrue(location instanceof Location);
    }

    @Test
    void returnsNameAttributeCorrectly_String() {
        Location location = new Location("Zone F");
        assertEquals( "Zone F", location.getName());
    }

    @Test
    void equals_comparesContents() {
        Location location = new Location("Zone Q");
        Location location2 = new Location("Zone Q");
        assertEquals(location, location2);
    }
}
