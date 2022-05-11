package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ranger {
    private String rangerName;
    private int contact;
    private  String badgeNumber;
    private int id;
    private List<Ranger> rangerList = new ArrayList<>();

    public void addRanger( List<Ranger> list, Ranger ranger){
        if(list != null){
            rangerList = list;
        }
        assert list != null;
        rangerList.add(ranger);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Ranger> getRangerList() {
        return rangerList;
    }

    public void setRangerList(List<Ranger> rangerList) {
        this.rangerList = rangerList;
    }

    public Ranger(String rangerName, int contact, String badgeNumber) {
        this.rangerName = rangerName;
        this.contact = contact;
        this.badgeNumber = badgeNumber;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ranger ranger = (Ranger) o;

        if (contact != ranger.contact) return false;
        if (!Objects.equals(rangerName, ranger.rangerName)) return false;
        return Objects.equals(badgeNumber, ranger.badgeNumber);
    }

    @Override
    public int hashCode() {
        int result = rangerName != null ? rangerName.hashCode() : 0;
        result = 31 * result + contact;
        result = 31 * result + (badgeNumber != null ? badgeNumber.hashCode() : 0);
        return result;
    }
}
