package ardi.springintro.model;

public class Person {
  String gender;
  String name;

  public Person() {
  }

  public Person(String gender, String name) {
    this.gender = gender;
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
