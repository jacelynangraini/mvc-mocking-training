package ardi.springintro.model;

import java.util.List;

public class SwapiPeopleResponse<T> {
  String name;
  String gender;

  public SwapiPeopleResponse() {
  }

  public SwapiPeopleResponse(String name, String gender) {
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
