package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Sighting {
    private int animalId;
    private String location;
    private String rangerName;
    private  int id;
    private LocalDate createdAt;
    public Sighting(int animalId, String location, String rangerName) {
        this.animalId = animalId;
        this.createdAt = LocalDate.now();
        this.location = location;
        this.rangerName = rangerName;
    }
    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sighting sighting = (Sighting) o;

        if (animalId != sighting.animalId) return false;
        if (id != sighting.id) return false;
        if (!Objects.equals(location, sighting.location)) return false;
        return Objects.equals(rangerName, sighting.rangerName);
    }

    @Override
    public int hashCode() {
        int result = animalId;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (rangerName != null ? rangerName.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
