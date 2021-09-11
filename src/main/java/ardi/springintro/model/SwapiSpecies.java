package ardi.springintro.model;

public class SwapiSpecies {
    String name;
    String classification;
    String language;

    public SwapiSpecies() {
    }

    public SwapiSpecies(String name, String classification, String language) {
        this.name = name;
        this.classification = classification;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
