package models;

import java.util.Objects;

public class EndangeredAnimal extends Animal {
    private  String health;
    private String age;

    public EndangeredAnimal(String name, String health, String age) {
        super(name);
        this.health = health;
        this.age = age;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        EndangeredAnimal that = (EndangeredAnimal) o;

        if (!Objects.equals(health, that.health)) return false;
        return Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (health != null ? health.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}
