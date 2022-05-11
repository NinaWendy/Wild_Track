package models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RangerTest {
    @Test
    void instantiatesCorrectly_True() {
        Ranger ranger = new Ranger("JohnDoe",0725323232,"SD58");
        assertTrue(ranger instanceof Ranger);
    }

    @Test
    void returnsNameAttributeCorrectly_String() {
        Ranger ranger = new Ranger("JohnDoe",0725323232,"SD58");
        assertEquals( "JohnDoe", ranger.getRangerName());
    }

    @Test
    void equals_comparesContents() {
        Ranger ranger = new Ranger("JohnDoe",0725323232,"SD58");
        Ranger ranger2 = new Ranger("JohnDoe",0725323232,"SD58");
        assertEquals(ranger, ranger2);
    }

    @Test
    void rangerList_returnsListOfAllRangers() {
        Ranger ranger = new Ranger("JohnDoe",0725323232,"SD58");
        Ranger ranger2 = new Ranger("JaneDoe",0734112323,"SD58");
        List<Ranger> rangerList = new ArrayList<>();
        rangerList.add(ranger);
        rangerList.add(ranger2);
        assertEquals(2,rangerList.size());
    }
}
