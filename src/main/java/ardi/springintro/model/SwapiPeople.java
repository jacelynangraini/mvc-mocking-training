package ardi.springintro.model;

public class SwapiPeople {
    String name;
    String gender;

    public SwapiPeople() {
    }

    public SwapiPeople(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
